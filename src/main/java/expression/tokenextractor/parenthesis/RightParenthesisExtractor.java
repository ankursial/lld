package expression.tokenextractor.parenthesis;

import expression.token.FixedValueToken;
import expression.token.paenthesis.Parenthesis;
import expression.token.paenthesis.RightParenthesis;

public class RightParenthesisExtractor extends ParenthesisExtractor {

  private static final Parenthesis rightParenthesisInstance = new RightParenthesis();

  @Override
  protected FixedValueToken getToken() {
    return rightParenthesisInstance;
  }
}
