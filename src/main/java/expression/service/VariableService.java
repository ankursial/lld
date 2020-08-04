package expression.service;

import expression.myexception.UnsupportedOperandException;
import expression.token.operand.Operand;
import expression.token.operand.variable.VariableOperand;
import expression.token.token.Token;
import java.util.List;

public interface VariableService {

  Operand convertVariable(VariableOperand variable) throws UnsupportedOperandException;

  List<Token> replaceVariablesWithOperands(List<Token> operandAndVariables)
      throws UnsupportedOperandException;
}
