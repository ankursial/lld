package expression.service;

import expression.factory.OperandFactory;
import expression.myexception.UnsupportedOperandException;
import expression.token.operand.Operand;
import expression.token.operand.OperandType;
import expression.token.operand.VariableOperand;
import expression.token.Token;
import expression.token.TokenType;
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
  public List<Token> replaceVariablesWithOperands(List<Token> operandAndVariables)
      throws UnsupportedOperandException {
    List<Token> retVal = new ArrayList<>();
    for (Token token : operandAndVariables) {
      if (isVariable(token)) {
        token = convertVariable((VariableOperand) token);
      }
      //NOTE: list type not supported for now
      retVal.add(token);
    }
    return retVal;
  }

  private boolean isVariable(Token token) {
    if (token.getTokenType().equals(TokenType.OPERAND)) {
      Operand operand = (Operand) token;
      return operand.getOperandType().equals(OperandType.VARIABLE);
    }

    return false;
  }
}
