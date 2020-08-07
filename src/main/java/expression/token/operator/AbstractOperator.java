package expression.token.operator;

import expression.myexception.InvalidEvaluationException;
import expression.token.FixedValueToken;
import expression.token.operand.AbstractOperand;
import expression.token.TokenType;
import java.util.List;

public abstract class AbstractOperator extends FixedValueToken {

  public abstract int getPrecedence();

  public abstract int getRequiredOperandCount();

  protected abstract boolean isSupportedOperandsInOrder(List<AbstractOperand> operands);

  public abstract AbstractOperand applyOnValidOperands(List<AbstractOperand> operands);

  public AbstractOperand apply(List<AbstractOperand> operands) throws InvalidEvaluationException {
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
