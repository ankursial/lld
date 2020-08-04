package expression.token.operator.utils;

import expression.token.operand.BooleanOperand;
import expression.token.operand.Operand;
import expression.token.operand.number.NumberOperand;

public class OperandToJavaTypeConverter {

  public static Boolean getBoolean(Operand operand) {
    BooleanOperand booleanOperand = (BooleanOperand) operand;
    return Boolean.valueOf(booleanOperand.toString().toLowerCase());
  }

  public static Double getDouble(Operand operand) {
    NumberOperand numberOperand = (NumberOperand) operand;
    return Double.valueOf(numberOperand.toString());
  }
}
