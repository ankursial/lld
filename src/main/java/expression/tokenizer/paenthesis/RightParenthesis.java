package expression.tokenizer.paenthesis;

import expression.tokenizer.token.TokenType;
import java.util.Objects;

public class RightParenthesis extends Parenthesis {

  private final String value = ")";

  @Override
  public TokenType getTokenType() {
    return TokenType.RIGHT_PARENTHESIS;
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
    if (!(o instanceof RightParenthesis)) {
      return false;
    }
    RightParenthesis that = (RightParenthesis) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
