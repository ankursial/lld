package expression.tokenizer.operand;

import expression.tokenizer.exception.InvalidTokenException;
import expression.tokenizer.token.Token;
import expression.tokenizer.token.TokenExtractor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperandExtractor implements TokenExtractor {

  private static final Character START_DIGIT = '"';
  protected static int extractorPriority = 4; //to enable true/false

  @Override
  public boolean startsWithSupportedToken(String expression, int startNdx) {
    return START_DIGIT.equals(expression.charAt(startNdx));
  }

  @Override
  public Token extractToken(String expression, int startNdx) throws InvalidTokenException {
    final String regex = "[^\"]+";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    if (matcher.find()) {
      return new StringOperand(matcher.group());
    }

    throw new InvalidTokenException(
        "Invalid integer token:" + expression.charAt(startNdx)
            + ", match at index: " + startNdx
            + ", for expression:" + expression);
  }

}
