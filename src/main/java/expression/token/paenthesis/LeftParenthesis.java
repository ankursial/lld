package expression.token.paenthesis;

import expression.token.TokenType;
import java.util.Objects;

public class LeftParenthesis extends AbstractParenthesis {

  private final String value = "(";

  @Override
  public TokenType getTokenType() {
    return TokenType.LEFT_PARENTHESIS;
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
