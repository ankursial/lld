package expression.evaluator;

import expression.converter.ExpressionConverter;
import expression.converter.InfixToPostfixConverter;
import expression.myexception.InvalidEvaluationException;
import expression.myexception.InvalidTokenException;
import expression.token.operand.BooleanOperand;
import expression.token.operand.Operand;
import expression.token.token.Token;
import expression.tokenizer.Tokenizer;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PostfixExpressionEvaluatorTest {

  @Test
  void evaluateTestToTrue() throws InvalidTokenException, InvalidEvaluationException {
    String input = "(5 < 10)";
    List<Token> tokenized = Tokenizer.tokenize(input);
    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);
    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    Operand result = expressionEvaluator.evaluate(postfixExpression);
    Assert.assertEquals(new BooleanOperand("true"), result);
  }

  @Test
  void evaluateTestToFalse() throws InvalidTokenException, InvalidEvaluationException {
    String input = "15 < 10";
    List<Token> tokenized = Tokenizer.tokenize(input);
    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);
    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    Operand result = expressionEvaluator.evaluate(postfixExpression);
    Assert.assertEquals(new BooleanOperand("false"), result);
  }

  @Test
  void evaluateTest() throws InvalidTokenException, InvalidEvaluationException {
    String input = "(5 < 10 AND 10 < 15)";
    List<Token> tokenized = Tokenizer.tokenize(input);
    ExpressionConverter expressionConverter = new InfixToPostfixConverter();
    List<Token> postfixExpression = expressionConverter.convert(tokenized);
    ExpressionEvaluator expressionEvaluator = new PostfixExpressionEvaluator();
    Operand result = expressionEvaluator.evaluate(postfixExpression);
    Assert.assertEquals(new BooleanOperand("true"), result);
  }

}