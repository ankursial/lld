package expression.evaluator.paenthesis;

import expression.evaluator.fixedvalue.FixedValueToken;
import expression.evaluator.tokenizer.TokenizerRegistry;

public class LeftParenthesisExtractor extends ParenthesisExtractor {

  private static final LeftParenthesis leftParenthesisInstance = new LeftParenthesis();

  static {
    TokenizerRegistry.register(new LeftParenthesisExtractor(), extractorPriority);
  }

  @Override
  protected FixedValueToken getToken() {
    return leftParenthesisInstance;
  }
}
