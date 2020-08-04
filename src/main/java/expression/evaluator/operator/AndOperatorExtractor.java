package expression.evaluator.operator;

import expression.evaluator.fixedvalue.FixedValueToken;
import expression.evaluator.tokenizer.TokenizerRegistry;

public class AndOperatorExtractor extends OperatorExtractor {

  private static final AndOperator instance = new AndOperator();

  static {
    TokenizerRegistry.register(new AndOperatorExtractor(), extractorPriority);
  }

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
