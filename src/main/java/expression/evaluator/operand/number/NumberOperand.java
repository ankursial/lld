package expression.evaluator.operand.number;

import expression.evaluator.token.Token;

public abstract class NumberOperand implements Token {

  public abstract String getStringValue();

  @Override
  public int getStringLength() {
    return getStringValue().length();
  }

  @Override
  public String toString() {
    return getStringValue();
  }
}
