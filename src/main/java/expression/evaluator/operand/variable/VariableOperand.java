package expression.evaluator.operand.variable;

import expression.evaluator.token.Token;

public class VariableOperand implements Token {

  String value;

  public VariableOperand(String value) {
    this.value = value;
  }

  @Override
  public int getStringLength() {
    return value.length();
  }

  @Override
  public String toString() {
    return value;
  }
}
