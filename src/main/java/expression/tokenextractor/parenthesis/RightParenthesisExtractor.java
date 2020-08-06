package expression.tokenextractor.parenthesis;

import expression.token.FixedValueToken;
import expression.token.paenthesis.AbstractParenthesis;
import expression.token.paenthesis.RightParenthesis;

public class RightParenthesisExtractor extends AbstractParenthesisExtractor {

  private static final AbstractParenthesis rightParenthesisInstance = new RightParenthesis();

  @Override
  protected FixedValueToken getToken() {
    return rightParenthesisInstance;
  }
}
