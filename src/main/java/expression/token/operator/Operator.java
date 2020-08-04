package expression.token.operator;

import expression.myexception.InvalidEvaluationException;
import expression.token.fixedvalue.FixedValueToken;
import expression.token.operand.Operand;
import expression.token.token.TokenType;
import java.util.List;

public abstract class Operator extends FixedValueToken {

  public abstract int getPrecedence();

  public abstract int getRequiredOperandCount();

  protected abstract boolean isSupportedOperandsInOrder(List<Operand> operands);

  public abstract Operand applyOnValidOperands(List<Operand> operands);

  public Operand apply(List<Operand> operands) throws InvalidEvaluationException {
    if (isSupportedOperandsInOrder(operands)) {
      return applyOnValidOperands(operands);
    }

    throw new InvalidEvaluationException(
        "Invalid Operands: " + operands + ", for operator " + toString());
  }


  @Override
  public TokenType getTokenType() {
    return TokenType.OPERATOR;
  }
}
