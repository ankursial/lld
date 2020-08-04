package expression.evaluator.tokenizer;

import expression.evaluator.exception.InvalidTokenException;
import expression.evaluator.operand.BooleanOperand;
import expression.evaluator.operand.BooleanOperandExtractor;
import expression.evaluator.operand.StringOperand;
import expression.evaluator.operand.StringOperandExtractor;
import expression.evaluator.operand.number.IntegerOperand;
import expression.evaluator.operand.number.IntegerOperandExtractor;
import expression.evaluator.operand.variable.VariableOperand;
import expression.evaluator.operand.variable.VariableOperandExtractor;
import expression.evaluator.operator.AndOperator;
import expression.evaluator.operator.AndOperatorExtractor;
import expression.evaluator.operator.LessThanOperator;
import expression.evaluator.operator.LessThanOperatorExtractor;
import expression.evaluator.operator.NoneOfOperator;
import expression.evaluator.operator.NoneOfOperatorExtractor;
import expression.evaluator.paenthesis.LeftParenthesis;
import expression.evaluator.paenthesis.LeftParenthesisExtractor;
import expression.evaluator.paenthesis.RightParenthesis;
import expression.evaluator.paenthesis.RightParenthesisExtractor;
import expression.evaluator.token.Token;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TokenizerTest {

  private static void simulateDependencyInjection() {
    LeftParenthesisExtractor leftParenthesisExtractor = new LeftParenthesisExtractor();
    RightParenthesisExtractor rightParenthesisExtractor = new RightParenthesisExtractor();
    LessThanOperatorExtractor lessThanOperatorExtractor = new LessThanOperatorExtractor();
    IntegerOperandExtractor integerOperandExtractor = new IntegerOperandExtractor();
    NoneOfOperatorExtractor noneOfOperatorExtractor = new NoneOfOperatorExtractor();
    AndOperatorExtractor andOperatorExtractor = new AndOperatorExtractor();
    VariableOperandExtractor variableOperandExtractor = new VariableOperandExtractor();
    StringOperandExtractor stringOperandExtractor = new StringOperandExtractor();
    BooleanOperandExtractor booleanOperandExtractor = new BooleanOperandExtractor();
  }

  @BeforeEach
  void setUp() {
    simulateDependencyInjection();
  }

  @Test
  void tokenizeTest() throws InvalidTokenException {
    String input = "(5 < 10) AND variable \"$string\" NONEOF (5, 10, 15) true";
    List<Token> result = Tokenizer.tokenize(input);
    Assert.assertEquals(new LeftParenthesis(), result.get(0));
    Assert.assertEquals(new IntegerOperand("5"), result.get(1));
    Assert.assertEquals(new LessThanOperator(), result.get(2));
    Assert.assertEquals(new IntegerOperand("10"), result.get(3));
    Assert.assertEquals(new RightParenthesis(), result.get(4));
    Assert.assertEquals(new AndOperator(), result.get(5));
    Assert.assertEquals(new VariableOperand("variable"), result.get(6));
    Assert.assertEquals(new StringOperand("$string"), result.get(7));
    Assert.assertEquals(new NoneOfOperator(), result.get(8));
    Assert.assertEquals(new LeftParenthesis(), result.get(9));
    Assert.assertEquals(new IntegerOperand("5"), result.get(10));
    Assert.assertEquals(new IntegerOperand("10"), result.get(11));
    Assert.assertEquals(new IntegerOperand("15"), result.get(12));
    Assert.assertEquals(new RightParenthesis(), result.get(13));
    Assert.assertEquals(new BooleanOperand("trUe"), result.get(14));
  }
}
