package expression.token.operator;

import expression.token.operand.BooleanOperand;
import expression.token.operand.ListOperand;
import expression.token.operand.Operand;
import expression.token.operand.OperandType;
import expression.utils.OperandValidator;
import expression.token.Token;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    if (!OperandValidator.isOperandType(operands.get(0), OperandType.LIST)) {
      return false;
    }

    OperandType operandType = operands.get(1).getOperandType();
    List<Token> groupTokens = ((ListOperand) operands.get(0)).getGroupTokens();

    List<Operand> listOperands = groupTokens.stream().map(x -> (Operand) x)
        .collect(Collectors.toList());

    return OperandValidator.areAllPassedOperandType(listOperands, operandType);
  }

  @Override
  public Operand applyOnValidOperands(List<Operand> operands) {
    List<Token> groupTokens = ((ListOperand) operands.get(0)).getGroupTokens();
    Boolean retval = !groupTokens.contains(operands.get(1));
    return new BooleanOperand(retval.toString());
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
