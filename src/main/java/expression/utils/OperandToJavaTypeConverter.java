package expression.utils;

import expression.token.operand.AbstractOperand;
import expression.token.operand.BooleanOperand;
import expression.token.operand.NumberOperand;

public class OperandToJavaTypeConverter {

  public static Boolean getBoolean(AbstractOperand operand) {
    BooleanOperand booleanOperand = (BooleanOperand) operand;
    return Boolean.valueOf(booleanOperand.toString().toLowerCase());
  }

  public static Double getDouble(AbstractOperand operand) {
    NumberOperand numberOperand = (NumberOperand) operand;
    return Double.valueOf(numberOperand.toString());
  }
}
