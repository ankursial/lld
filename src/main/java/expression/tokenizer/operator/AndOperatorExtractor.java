package expression.tokenizer.operator;

import expression.tokenizer.fixedvalue.FixedValueToken;

public class AndOperatorExtractor extends OperatorExtractor {

  private static final AndOperator instance = new AndOperator();

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
