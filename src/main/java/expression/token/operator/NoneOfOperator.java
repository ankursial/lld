package expression.token.operator;

import expression.token.operand.Operand;
import java.util.List;
import java.util.Objects;

public class NoneOfOperator extends Operator {

  private final String value = "NONEOF";

  @Override
  public int getPrecedence() {
    return 9;
  }

  @Override
  public int getRequiredOperandCount() {
    return 2;
  }

  @Override
  protected boolean isSupportedOperandsInOrder(List<Operand> operands) {
    //todo
    return false;
  }

  @Override
  public Operand applyOnValidOperands(List<Operand> operands) {
    //todo
    return null;
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
    if (!(o instanceof NoneOfOperator)) {
      return false;
    }
    NoneOfOperator that = (NoneOfOperator) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
