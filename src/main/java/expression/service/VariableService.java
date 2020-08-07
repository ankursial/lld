package expression.service;

import expression.myexception.UnsupportedOperandException;
import expression.token.operand.AbstractOperand;
import expression.token.operand.VariableOperand;
import expression.token.Token;
import java.util.List;

public interface VariableService {

  AbstractOperand convertVariable(VariableOperand variable) throws UnsupportedOperandException;

  List<Token> replaceVariablesWithOperands(List<Token> operandAndVariables)
      throws UnsupportedOperandException;
}
