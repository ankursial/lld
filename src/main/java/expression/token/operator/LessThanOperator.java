package expression.token.operator;

import expression.token.operand.BooleanOperand;
import expression.token.operand.Operand;
import expression.token.operand.OperandType;
import expression.token.operator.utils.OperandToJavaTypeConverter;
import expression.token.operator.utils.OperandValidator;
import java.util.List;
import java.util.Objects;

public class LessThanOperator extends Operator {

  private final String value = "<";

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
    return OperandValidator.areAllPassedOperandType(operands, OperandType.NUMBER);
  }

  @Override
  public Operand applyOnValidOperands(List<Operand> operands) {
    Double operandB = OperandToJavaTypeConverter.getDouble(operands.get(0));
    Double operandA = OperandToJavaTypeConverter.getDouble(operands.get(1));

    Boolean result = operandA < operandB;
    return new BooleanOperand(result.toString());
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
    if (!(o instanceof LessThanOperator)) {
      return false;
    }
    LessThanOperator that = (LessThanOperator) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
