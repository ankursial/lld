package expression.tokenizer.operator;

import expression.tokenizer.fixedvalue.FixedValueToken;
import expression.tokenizer.token.TokenType;

public abstract class Operator extends FixedValueToken {

  public abstract int getPrecedence();

  @Override
  public TokenType getTokenType() {
    return TokenType.OPERATOR;
  }
}
