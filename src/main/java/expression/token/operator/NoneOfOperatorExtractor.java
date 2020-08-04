package expression.token.operator;

import expression.token.fixedvalue.FixedValueToken;

public class NoneOfOperatorExtractor extends OperatorExtractor {

  private static final NoneOfOperator instance = new NoneOfOperator();

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
