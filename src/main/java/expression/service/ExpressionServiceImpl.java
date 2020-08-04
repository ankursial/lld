package expression.service;

import expression.converter.ExpressionConverter;
import expression.converter.InfixToPostfixConverter;
import expression.evaluator.ExpressionEvaluator;
import expression.evaluator.PostfixExpressionEvaluator;
import expression.myexception.InvalidEvaluationException;
import expression.myexception.InvalidTokenException;
import expression.myexception.UnsupportedOperandException;
import expression.token.operand.Operand;
import expression.token.operand.OperandType;
import expression.token.token.Token;
import expression.tokenizer.Tokenizer;
import java.util.List;
import java.util.Map;

public class ExpressionServiceImpl implements ExpressionService {

  @Override
  public boolean isAllowed(String conditionalExpression, Map<String, Object> user)
      throws InvalidEvaluationException, InvalidTokenException, UnsupportedOperandException {
    return evaluateBooleanResultExpression(conditionalExpression, user);
  }

  private boolean evaluateBooleanResultExpression(String conditionalExpression,
      Map<String, Object> user)
      throws InvalidEvaluationException, InvalidTokenException, UnsupportedOperandException {
    Operand result = evaluateExpression(conditionalExpression, user);
    if (!result.getOperandType().equals(OperandType.BOOLEAN)) {
      throw new InvalidEvaluationException("Evaluation did not result into boolean output");
    }

    return Boolean.parseBoolean(result.toString());
  }

  private Operand evaluateExpression(String expression, Map<String, Object> userMap)
      throws InvalidTokenException, UnsupportedOperandException, InvalidEvaluationException {
    List<Token> tokenized = Tokenizer.tokenize(expression);

    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);

    UserService userService = new UserServiceImpl(userMap);
    VariableService variableService = new VariableServiceImpl(userService);
    List<Token> expressionWithoutVariables =
        variableService.replaceVariablesWithOperands(postfixExpression);

    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    return expressionEvaluator.evaluate(expressionWithoutVariables);
  }
}