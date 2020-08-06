package expression.token.operand;

public abstract class NumberOperand extends AbstractOperand {

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
