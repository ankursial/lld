package expression.token.paenthesis;

import expression.token.fixedvalue.FixedValueToken;

public class LeftParenthesisExtractor extends ParenthesisExtractor {

  private static final LeftParenthesis leftParenthesisInstance = new LeftParenthesis();

  @Override
  protected FixedValueToken getToken() {
    return leftParenthesisInstance;
  }
}
