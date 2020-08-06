package expression.token.operand;

import java.util.Objects;

public class StringOperand extends AbstractOperand {

  String value;

  public StringOperand(String value) {
    this.value = value;
  }

  @Override
  public int getStringLength() {
    return value.length() + 2;
  }

  @Override
  public OperandType getOperandType() {
    return OperandType.STRING;
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
    if (!(o instanceof StringOperand)) {
      return false;
    }
    StringOperand that = (StringOperand) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
