package expression.token.fixedvalue;

import expression.token.token.Token;
import expression.token.token.TokenExtractor;

public abstract class FixedValueTokenExtractor implements TokenExtractor {

  protected abstract FixedValueToken getToken();

  @Override
  public boolean startsWithSupportedToken(String expression, int startNdx) {
    String value = getToken().getStringValue();
    return expression.regionMatches(startNdx, value, 0, value.length());
  }

  @Override
  public Token extractToken(String expression, int startNdx) {
    return getToken();
  }
}
