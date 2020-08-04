package expression.evaluator.operator;

import java.util.Objects;

public class LessThanOperator extends Operator {

  private final String value = "<";

  @Override
  public String getStringValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LessThanOperator)) {
      return false;
    }
    LessThanOperator that = (LessThanOperator) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
