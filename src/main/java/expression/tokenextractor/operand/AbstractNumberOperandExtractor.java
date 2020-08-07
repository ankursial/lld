package expression.tokenextractor.operand;

import expression.tokenextractor.TokenExtractor;

public abstract class AbstractNumberOperandExtractor implements TokenExtractor {

  private static final String START_DIGITS = "1234567890";

  @Override
  public boolean startsWithSupportedToken(String expression, int startNdx) {
    return START_DIGITS.indexOf(expression.charAt(startNdx)) != -1;
  }
}
