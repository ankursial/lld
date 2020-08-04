package expression.tokenizer.operand;

import expression.tokenizer.token.Token;
import expression.tokenizer.token.TokenType;

public abstract class Operand implements Token {

  @Override
  public TokenType getTokenType() {
    return TokenType.OPERAND;
  }
}
