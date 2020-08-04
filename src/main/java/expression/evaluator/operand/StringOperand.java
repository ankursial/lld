package expression.evaluator.operand;

import expression.evaluator.token.Token;

public class StringOperand implements Token {

  String value;

  public StringOperand(String value) {
    this.value = value;
  }

  @Override
  public int getStringLength() {
    return value.length() + 2;
  }

  @Override
  public String toString() {
    return value;
  }
}
