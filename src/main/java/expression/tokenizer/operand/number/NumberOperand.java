package expression.tokenizer.operand.number;

import expression.tokenizer.operand.Operand;

public abstract class NumberOperand extends Operand {

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
