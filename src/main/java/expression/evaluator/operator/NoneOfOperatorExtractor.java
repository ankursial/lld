package expression.evaluator.operator;

import expression.evaluator.fixedvalue.FixedValueToken;
import expression.evaluator.tokenizer.TokenizerRegistry;

public class NoneOfOperatorExtractor extends OperatorExtractor {

  private static final NoneOfOperator instance = new NoneOfOperator();

  static {
    TokenizerRegistry.register(new NoneOfOperatorExtractor(), extractorPriority);
  }

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
