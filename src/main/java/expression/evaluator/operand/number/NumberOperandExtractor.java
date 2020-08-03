package expression.evaluator.operand.number;

import expression.evaluator.token.TokenExtractor;

public abstract class NumberOperandExtractor implements TokenExtractor {

  private static final String START_DIGITS = "1234567890";
  protected static int extractorPriority = 2;

  @Override
  public boolean startsWithSupportedToken(String expression, int startNdx) {
    return START_DIGITS.indexOf(expression.charAt(startNdx)) != -1;
  }
}
