package expression.service;

import expression.myexception.UnsupportedOperandException;
import expression.token.operand.Operand;
import expression.token.operand.variable.VariableOperand;
import java.util.List;

public interface VariableService {

  Operand convertVariable(VariableOperand variable) throws UnsupportedOperandException;

  List<Operand> replaceVariablesWithOperands(List<Operand> operandAndVariables)
      throws UnsupportedOperandException;
}
