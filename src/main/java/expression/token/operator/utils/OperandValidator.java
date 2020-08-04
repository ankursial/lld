package expression.token.operator.utils;

import expression.token.operand.Operand;
import expression.token.operand.OperandType;
import java.util.List;

public class OperandValidator {

  public static boolean areAllPassedOperandType(List<Operand> operands, OperandType operandType) {
    for (Operand operand : operands) {
      if (!isOperandType(operand, operandType)) {
        return false;
      }
    }

    return true;
  }

  public static boolean isOperandType(Operand operand, OperandType operandType) {
    return operand.getOperandType().equals(operandType);
  }
}
