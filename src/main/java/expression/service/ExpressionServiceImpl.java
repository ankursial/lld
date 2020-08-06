package expression.service;

import expression.converter.ExpressionConverter;
import expression.converter.InfixToPostfixConverter;
import expression.evaluator.ExpressionEvaluator;
import expression.evaluator.PostfixExpressionEvaluator;
import expression.myexception.InvalidEvaluationException;
import expression.myexception.InvalidTokenException;
import expression.myexception.UnsupportedOperandException;
import expression.token.operand.AbstractOperand;
import expression.token.operand.OperandType;
import expression.token.Token;
import expression.tokenizer.Tokenizer;
import expression.tokenizer.TokenizerImpl;
import java.util.List;
import java.util.Map;

public class ExpressionServiceImpl implements ExpressionService {

  private Tokenizer tokenizer;
  private ExpressionConverter expressionConverter;
  private VariableService variableService;
  private ExpressionEvaluator expressionEvaluator;

  @Override
  public boolean isAllowed(String conditionalExpression, Map<String, Object> user)
      throws InvalidEvaluationException, InvalidTokenException, UnsupportedOperandException {
    return evaluateBooleanResultExpression(conditionalExpression, user);
  }

  private boolean evaluateBooleanResultExpression(String conditionalExpression,
      Map<String, Object> user)
      throws InvalidEvaluationException, InvalidTokenException, UnsupportedOperandException {
    AbstractOperand result = evaluateExpression(conditionalExpression, user);
    if (!result.getOperandType().equals(OperandType.BOOLEAN)) {
      throw new InvalidEvaluationException("Evaluation did not result into boolean output");
    }

    return Boolean.parseBoolean(result.toString());
  }

  private AbstractOperand evaluateExpression(String expression, Map<String, Object> userMap)
      throws InvalidTokenException, UnsupportedOperandException, InvalidEvaluationException {

    //DI
    UserService userService = new UserServiceImpl(userMap);
    variableService = new VariableServiceImpl(userService);
    expressionEvaluator = new PostfixExpressionEvaluator();
    expressionConverter = new InfixToPostfixConverter();
    tokenizer = new TokenizerImpl();

    List<Token> tokenized = tokenizer.tokenize(expression);

    List<Token> postfixExpression = expressionConverter.convert(tokenized);

    List<Token> expressionWithoutVariables =
        variableService.replaceVariablesWithOperands(postfixExpression);

    return expressionEvaluator.evaluate(expressionWithoutVariables);
  }
}