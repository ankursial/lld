package expression.token.operand;

import java.util.Objects;

public class BooleanOperand extends AbstractOperand {

  //todo replace with factory

  String value;

  public BooleanOperand(String value) {
    this.value = value;
  }

  @Override
  public int getStringLength() {
    return value.length();
  }

  @Override
  public OperandType getOperandType() {
    return OperandType.BOOLEAN;
  }

  @Override
  public String toString() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BooleanOperand)) {
      return false;
    }
    BooleanOperand that = (BooleanOperand) o;
    return Objects.equals(value.toLowerCase(), that.value.toLowerCase());
  }

  @Override
  public int hashCode() {
    return Objects.hash(value.toLowerCase());
  }
}
