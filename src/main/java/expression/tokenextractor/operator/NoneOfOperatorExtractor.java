package expression.tokenextractor.operator;

import expression.token.FixedValueToken;
import expression.token.operator.NoneOfOperator;

public class NoneOfOperatorExtractor extends AbstractOperatorExtractor {

  private static final NoneOfOperator instance = new NoneOfOperator();

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
