package expression.tokenizer.fixedvalue;

import expression.tokenizer.token.Token;
import expression.tokenizer.token.TokenExtractor;

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
