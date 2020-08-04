package expression.token.operator;

import expression.token.fixedvalue.FixedValueToken;

public class AndOperatorExtractor extends OperatorExtractor {

  private static final AndOperator instance = new AndOperator();

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
