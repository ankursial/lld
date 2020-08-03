package expression.evaluator.operator;

import expression.evaluator.fixedvalue.FixedValueToken;
import expression.evaluator.tokenizer.TokenizerRegistry;

public class LessThanOperatorExtractor extends OperatorExtractor {

  private static final LessThanOperator instance = new LessThanOperator();

  static {
    TokenizerRegistry.register(new LessThanOperatorExtractor(), extractorPriority);
  }

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
