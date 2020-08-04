package expression.tokenizer.tokenizer;

import expression.tokenizer.exception.InvalidTokenException;
import expression.tokenizer.operand.BooleanOperand;
import expression.tokenizer.operand.StringOperand;
import expression.tokenizer.operand.number.IntegerOperand;
import expression.tokenizer.operand.variable.VariableOperand;
import expression.tokenizer.operator.AndOperator;
import expression.tokenizer.operator.LessThanOperator;
import expression.tokenizer.operator.NoneOfOperator;
import expression.tokenizer.paenthesis.LeftParenthesis;
import expression.tokenizer.paenthesis.RightParenthesis;
import expression.tokenizer.token.Token;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


class TokenizerTest {

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
    Assert.assertEquals(new BooleanOperand("true"), result.get(14));
  }
}
