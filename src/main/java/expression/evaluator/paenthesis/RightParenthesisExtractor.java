package expression.evaluator.paenthesis;

import expression.evaluator.fixedvalue.FixedValueToken;
import expression.evaluator.tokenizer.TokenizerRegistry;

public class RightParenthesisExtractor extends ParenthesisExtractor {

  private static final Parenthesis rightParenthesisInstance = new RightParenthesis();

  static {
    TokenizerRegistry.register(new RightParenthesisExtractor(), extractorPriority);
  }

  @Override
  protected FixedValueToken getToken() {
    return rightParenthesisInstance;
  }
}
