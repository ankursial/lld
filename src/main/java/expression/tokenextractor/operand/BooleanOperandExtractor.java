package expression.tokenextractor.operand;

import expression.myexception.InvalidTokenException;
import expression.tokenextractor.TokenExtractor;
import expression.token.operand.BooleanOperand;
import expression.token.Token;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooleanOperandExtractor implements TokenExtractor {

  private final String pattern = "^(?i)(true|false)";

  @Override
  public boolean startsWithSupportedToken(String expression, int startNdx) {
    Pattern pattern = Pattern.compile(this.pattern);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    return matcher.find();
  }

  @Override
  public Token extractToken(String expression, int startNdx) throws InvalidTokenException {
    Pattern pattern = Pattern.compile(this.pattern);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    if (matcher.find()) {
      return new BooleanOperand(matcher.group());
    }

    throw new InvalidTokenException(
        "Invalid integer token:" + expression.charAt(startNdx)
            + ", match at index: " + startNdx
            + ", for expression:" + expression);
  }

}
