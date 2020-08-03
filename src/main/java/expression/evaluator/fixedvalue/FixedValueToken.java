package expression.evaluator.fixedvalue;

import expression.evaluator.token.Token;

public abstract class FixedValueToken implements Token {

  public abstract String getStringValue();

  @Override
  public int getStringLength() {
    return getStringValue().length();
  }

  @Override
  public String toString() {
    return getStringValue();
  }

}
