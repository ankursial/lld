package expression.service;

import expression.myexception.UnsupportedOperandException;
import expression.token.operand.Operand;
import expression.token.operand.OperandType;
import expression.token.operand.variable.VariableOperand;
import java.util.ArrayList;
import java.util.List;

public class VariableServiceImpl implements VariableService {

  private final UserService userService;
  private final OperandFactory operandFactory;

  public VariableServiceImpl(UserService userService) {
    this.userService = userService;
    this.operandFactory = new OperandFactory();
  }

  @Override
  public Operand convertVariable(VariableOperand key) throws UnsupportedOperandException {
    Object object = userService.getJavaObject(key.toString());
    return operandFactory.getOperand(object);
  }

  @Override
  public List<Operand> replaceVariablesWithOperands(List<Operand> operandAndVariables)
      throws UnsupportedOperandException {
    List<Operand> retVal = new ArrayList<>();
    for (Operand operand : operandAndVariables) {
      if (operand.getOperandType().equals(OperandType.VARIABLE)) {
        operand = convertVariable((VariableOperand) operand);
      }

      //NOTE: list type not supported for now
      retVal.add(operand);
    }
    return retVal;
  }
}
