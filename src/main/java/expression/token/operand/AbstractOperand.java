package expression.token.operand;

import expression.token.Token;
import expression.token.TokenType;

public abstract class AbstractOperand implements Token {

  @Override
  public TokenType getTokenType() {
    return TokenType.OPERAND;
  }

  public abstract OperandType getOperandType();
}
