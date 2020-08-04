package expression.tokenizer.operator;

import java.util.Objects;

public class AndOperator extends Operator {

  private final String value = "AND";

  @Override
  public int getPrecedence() {
    return 7;
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
    if (!(o instanceof AndOperator)) {
      return false;
    }
    AndOperator that = (AndOperator) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
