package expression.evaluator.operand;

import expression.evaluator.token.Token;

public class BooleanOperand implements Token {

  String value;

  public BooleanOperand(String value) {
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
