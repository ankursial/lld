package expression.tokenextractor;

import expression.token.FixedValueToken;
import expression.token.Token;

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
