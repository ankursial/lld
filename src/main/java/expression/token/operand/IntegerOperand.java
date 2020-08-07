package expression.token.operand;

import java.util.Objects;

public class IntegerOperand extends NumberOperand {

  private final String value;

  public IntegerOperand(String value) {
    this.value = value;
  }

  @Override
  public String getStringValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IntegerOperand)) {
      return false;
    }
    IntegerOperand that = (IntegerOperand) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
