package expression.token.operand;

import expression.token.operand.Operand;
import expression.token.operand.OperandType;

public abstract class NumberOperand extends Operand {

  public abstract String getStringValue();

  @Override
  public OperandType getOperandType() {
    return OperandType.NUMBER;
  }

  @Override
  public int getStringLength() {
    return getStringValue().length();
  }

  @Override
  public String toString() {
    return getStringValue();
  }
}
