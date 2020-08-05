package expression.tokenextractor.operand;

import expression.myexception.InvalidTokenException;
import expression.tokenextractor.TokenExtractor;
import expression.token.operand.StringOperand;
import expression.token.Token;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperandExtractor implements TokenExtractor {

  private static final Character START_DIGIT = '"';

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
