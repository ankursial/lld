package expression.token.operator;

import expression.token.fixedvalue.FixedValueToken;

public class LessThanOperatorExtractor extends OperatorExtractor {

  private static final LessThanOperator instance = new LessThanOperator();

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
