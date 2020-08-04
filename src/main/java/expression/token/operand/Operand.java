package expression.token.operand;

import expression.token.token.Token;
import expression.token.token.TokenType;

public abstract class Operand implements Token {

  @Override
  public TokenType getTokenType() {
    return TokenType.OPERAND;
  }

  public abstract OperandType getOperandType();
}
