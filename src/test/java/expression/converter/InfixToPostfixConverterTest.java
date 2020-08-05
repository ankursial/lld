package expression.converter;

import expression.myexception.InvalidTokenException;
import expression.token.operand.BooleanOperand;
import expression.token.operand.IntegerOperand;
import expression.token.operand.VariableOperand;
import expression.token.operator.AndOperator;
import expression.token.operator.LessThanOperator;
import expression.token.paenthesis.LeftParenthesis;
import expression.token.paenthesis.RightParenthesis;
import expression.token.Token;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class InfixToPostfixConverterTest {

  @Test
  void convertWithBrackets() throws InvalidTokenException {
    List<Token> infixExpr = new ArrayList<>();
    infixExpr.add(new LeftParenthesis());
    infixExpr.add(new IntegerOperand("5"));
    infixExpr.add(new LessThanOperator());
    infixExpr.add(new IntegerOperand("10"));
    infixExpr.add(new RightParenthesis());

    InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();

    List<Token> result = infixToPostfixConverter.convert(infixExpr);

    Assert.assertEquals(3, result.size());
    Assert.assertEquals(new IntegerOperand("5"), result.get(0));
    Assert.assertEquals(new IntegerOperand("10"), result.get(1));
    Assert.assertEquals(new LessThanOperator(), result.get(2));
  }

  @Test
  void convertWithVariable() throws InvalidTokenException {
    List<Token> infixExpr = new ArrayList<>();
    infixExpr.add(new IntegerOperand("5"));
    infixExpr.add(new LessThanOperator());
    infixExpr.add(new VariableOperand("someVariableName"));

    InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();

    List<Token> result = infixToPostfixConverter.convert(infixExpr);

    Assert.assertEquals(3, result.size());
    Assert.assertEquals(new IntegerOperand("5"), result.get(0));
    Assert.assertEquals(new VariableOperand("someVariableName"), result.get(1));
    Assert.assertEquals(new LessThanOperator(), result.get(2));
  }

  @Test
  void convertANDTest() throws InvalidTokenException {
    List<Token> infixExpr = new ArrayList<>();
    infixExpr.add(new IntegerOperand("5"));
    infixExpr.add(new LessThanOperator());
    infixExpr.add(new IntegerOperand("10"));
    infixExpr.add(new AndOperator());
    infixExpr.add(new IntegerOperand("6"));
    infixExpr.add(new LessThanOperator());
    infixExpr.add(new IntegerOperand("11"));

    InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();

    List<Token> result = infixToPostfixConverter.convert(infixExpr);

    Assert.assertEquals(7, result.size());
    Assert.assertEquals(new IntegerOperand("5"), result.get(0));
    Assert.assertEquals(new IntegerOperand("10"), result.get(1));
    Assert.assertEquals(new LessThanOperator(), result.get(2));
    Assert.assertEquals(new IntegerOperand("6"), result.get(3));
    Assert.assertEquals(new IntegerOperand("11"), result.get(4));
    Assert.assertEquals(new LessThanOperator(), result.get(5));
    Assert.assertEquals(new AndOperator(), result.get(6));
  }

  @Test
  void convertBooleanTest() throws InvalidTokenException {
    List<Token> infixExpr = new ArrayList<>();
    infixExpr.add(new IntegerOperand("5"));
    infixExpr.add(new LessThanOperator());
    infixExpr.add(new IntegerOperand("10"));
    infixExpr.add(new AndOperator());
    infixExpr.add(new BooleanOperand("true"));

    InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();

    List<Token> result = infixToPostfixConverter.convert(infixExpr);

    Assert.assertEquals(5, result.size());
    Assert.assertEquals(new IntegerOperand("5"), result.get(0));
    Assert.assertEquals(new IntegerOperand("10"), result.get(1));
    Assert.assertEquals(new LessThanOperator(), result.get(2));
    Assert.assertEquals(new BooleanOperand("true"), result.get(3));
    Assert.assertEquals(new AndOperator(), result.get(4));
  }
}