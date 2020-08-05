package expression.service;

import expression.myexception.UnsupportedOperandException;
import expression.token.operand.Operand;
import expression.token.operand.VariableOperand;
import expression.token.Token;
import java.util.List;

public interface VariableService {

  Operand convertVariable(VariableOperand variable) throws UnsupportedOperandException;

  List<Token> replaceVariablesWithOperands(List<Token> operandAndVariables)
      throws UnsupportedOperandException;
}
