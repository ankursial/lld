package expression.token.paenthesis;

import expression.token.fixedvalue.FixedValueToken;

public class RightParenthesisExtractor extends ParenthesisExtractor {

  private static final Parenthesis rightParenthesisInstance = new RightParenthesis();

  @Override
  protected FixedValueToken getToken() {
    return rightParenthesisInstance;
  }
}
