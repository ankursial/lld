package expression.utils;

import expression.token.operand.AbstractOperand;
import expression.token.operand.OperandType;
import java.util.List;

public class OperandValidator {

  public static boolean areAllPassedOperandType(List<AbstractOperand> operands, OperandType operandType) {
    for (AbstractOperand operand : operands) {
      if (!isOperandType(operand, operandType)) {
        return false;
      }
    }

    return true;
  }

  public static boolean isOperandType(AbstractOperand operand, OperandType operandType) {
    return operand.getOperandType().equals(operandType);
  }
}
