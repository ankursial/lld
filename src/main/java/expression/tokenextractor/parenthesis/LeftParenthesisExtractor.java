package expression.tokenextractor.parenthesis;

import expression.token.FixedValueToken;
import expression.token.paenthesis.LeftParenthesis;

public class LeftParenthesisExtractor extends ParenthesisExtractor {

  private static final LeftParenthesis leftParenthesisInstance = new LeftParenthesis();

  @Override
  protected FixedValueToken getToken() {
    return leftParenthesisInstance;
  }
}
