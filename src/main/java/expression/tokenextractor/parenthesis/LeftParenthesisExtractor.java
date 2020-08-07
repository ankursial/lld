package expression.tokenextractor.parenthesis;

import expression.token.FixedValueToken;
import expression.token.parenthesis.LeftParenthesis;

public class LeftParenthesisExtractor extends AbstractParenthesisExtractor {

  private static final LeftParenthesis leftParenthesisInstance = new LeftParenthesis();

  @Override
  protected FixedValueToken getToken() {
    return leftParenthesisInstance;
  }
}
