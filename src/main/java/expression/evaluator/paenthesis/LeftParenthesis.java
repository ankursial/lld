package expression.evaluator.paenthesis;

import java.util.Objects;

public class LeftParenthesis extends Parenthesis {

  private final String value = "(";

  @Override
  public String getStringValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LeftParenthesis)) {
      return false;
    }
    LeftParenthesis that = (LeftParenthesis) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
