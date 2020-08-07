package expression.tokenextractor.parenthesis;

import expression.token.FixedValueToken;
import expression.token.parenthesis.AbstractParenthesis;
import expression.token.parenthesis.RightParenthesis;

public class RightParenthesisExtractor extends AbstractParenthesisExtractor {

  private static final AbstractParenthesis rightParenthesisInstance = new RightParenthesis();

  @Override
  protected FixedValueToken getToken() {
    return rightParenthesisInstance;
  }
}
