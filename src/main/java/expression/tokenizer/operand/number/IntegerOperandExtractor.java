package expression.tokenizer.operand.number;

import expression.tokenizer.exception.InvalidTokenException;
import expression.tokenizer.token.Token;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerOperandExtractor extends NumberOperandExtractor {

  @Override
  public Token extractToken(String expression, int startNdx) throws InvalidTokenException {
    Pattern pattern = Pattern.compile("\\d+(?![a-zA-Z1-9])");
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    if (matcher.find()) {
      return new IntegerOperand(matcher.group());
    }

    throw new InvalidTokenException(
        "Invalid integer token:" + expression.charAt(startNdx)
            + ", match at index: " + startNdx
            + ", for expression:" + expression);
  }
}
