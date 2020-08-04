package expression.tokenizer.operator;

import expression.tokenizer.fixedvalue.FixedValueToken;

public class LessThanOperatorExtractor extends OperatorExtractor {

  private static final LessThanOperator instance = new LessThanOperator();

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
