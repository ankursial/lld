package expression.tokenizer.operator;

import java.util.Objects;

public class NoneOfOperator extends Operator {

  private final String value = "NONEOF";

  @Override
  public int getPrecedence() {
    return 9;
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
    if (!(o instanceof NoneOfOperator)) {
      return false;
    }
    NoneOfOperator that = (NoneOfOperator) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
