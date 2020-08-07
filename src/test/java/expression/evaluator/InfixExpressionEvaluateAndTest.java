package expression.evaluator;

import expression.converter.ExpressionConverter;
import expression.converter.InfixToPostfixConverter;
import expression.myexception.InvalidEvaluationException;
import expression.myexception.InvalidTokenException;
import expression.myexception.UnsupportedOperandException;
import expression.service.UserService;
import expression.service.UserServiceImpl;
import expression.service.VariableService;
import expression.service.VariableServiceImpl;
import expression.token.operand.AbstractOperand;
import expression.token.operand.BooleanOperand;
import expression.token.Token;
import expression.tokenizer.TokenizerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class InfixExpressionEvaluateAndTest {
  
  TokenizerImpl tokenizer = new TokenizerImpl();

  @Test
  void evaluateTestToTrue() throws InvalidTokenException, InvalidEvaluationException {
    String input = "(5 < 10)";
    List<Token> tokenized = tokenizer.tokenize(input);
    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);
    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    AbstractOperand result = expressionEvaluator.evaluate(postfixExpression);
    Assert.assertEquals(new BooleanOperand("true"), result);
  }

  @Test
  void evaluateTestToFalse() throws InvalidTokenException, InvalidEvaluationException {
    String input = "15 < 10";
    List<Token> tokenized = tokenizer.tokenize(input);
    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);
    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    AbstractOperand result = expressionEvaluator.evaluate(postfixExpression);
    Assert.assertEquals(new BooleanOperand("false"), result);
  }

  @Test
  void evaluateTest() throws InvalidTokenException, InvalidEvaluationException {
    String input = "(5 < 10 AND 10 < 15)";
    List<Token> tokenized = tokenizer.tokenize(input);
    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);
    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    AbstractOperand result = expressionEvaluator.evaluate(postfixExpression);
    Assert.assertEquals(new BooleanOperand("true"), result);
  }

  @Test
  void evaluateTestNoneOfTrue() throws InvalidTokenException, InvalidEvaluationException {
    String input = "(5 < 10 AND 10 < 15) AND 5 NONEOF (10,20,30)";
    List<Token> tokenized = tokenizer.tokenize(input);
    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);
    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    AbstractOperand result = expressionEvaluator.evaluate(postfixExpression);
    Assert.assertEquals(new BooleanOperand("true"), result);
  }

  @Test
  void evaluateTestNoneOfFalse() throws InvalidTokenException, InvalidEvaluationException {
    String input = "10 < 15 AND 10 NONEOF (10,20,30)";
    List<Token> tokenized = tokenizer.tokenize(input);
    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);
    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    AbstractOperand result = expressionEvaluator.evaluate(postfixExpression);
    Assert.assertEquals(new BooleanOperand("false"), result);
  }

  @Test
  void evaluateTestWithVariableResultTrue()
      throws InvalidTokenException, InvalidEvaluationException, UnsupportedOperandException {

    Map<String, Object> addressMap = new HashMap<>();
    addressMap.put("pincode", 110060);
    Map<String, Object> userMap = new HashMap<>();
    userMap.put("noOfOrders", 15);
    userMap.put("age", 15);
    userMap.put("address", addressMap);

    String input = " 5 < noOfOrders AND address#pincode < 200000 AND age < 30";
    List<Token> tokenized = tokenizer.tokenize(input);

    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);

    UserService userService = new UserServiceImpl(userMap);
    VariableService variableService = new VariableServiceImpl(userService);
    List<Token> expressionWithoutVariables =
        variableService.replaceVariablesWithOperands(postfixExpression);

    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    AbstractOperand result = expressionEvaluator.evaluate(expressionWithoutVariables);
    Assert.assertEquals(new BooleanOperand("true"), result);
  }

  @Test
  void evaluateTestWithVariableResultFalse()
      throws InvalidTokenException, InvalidEvaluationException, UnsupportedOperandException {

    Map<String, Object> addressMap = new HashMap<>();
    addressMap.put("pincode", 110060);
    Map<String, Object> userMap = new HashMap<>();
    userMap.put("noOfOrders", 15);
    userMap.put("age", 15);
    userMap.put("address", addressMap);

    String input = " 5 < noOfOrders AND address#pincode < 200000 AND 30 < age";
    List<Token> tokenized = tokenizer.tokenize(input);

    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);

    UserService userService = new UserServiceImpl(userMap);
    VariableService variableService = new VariableServiceImpl(userService);
    List<Token> expressionWithoutVariables =
        variableService.replaceVariablesWithOperands(postfixExpression);

    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    AbstractOperand result = expressionEvaluator.evaluate(expressionWithoutVariables);
    Assert.assertEquals(new BooleanOperand("false"), result);
  }
}
