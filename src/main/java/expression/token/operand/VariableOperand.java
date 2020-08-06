package expression.token.operand;

import java.util.Objects;

public class VariableOperand extends AbstractOperand {

  String value;

  public VariableOperand(String value) {
    this.value = value;
  }

  @Override
  public int getStringLength() {
    return value.length();
  }

  @Override
  public OperandType getOperandType() {
    return OperandType.VARIABLE;
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
    if (!(o instanceof VariableOperand)) {
      return false;
    }
    VariableOperand that = (VariableOperand) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
