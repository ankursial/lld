package expression.tokenextractor.operator;

import expression.token.FixedValueToken;
import expression.token.operator.LessThanOperator;

public class LessThanOperatorExtractor extends AbstractOperatorExtractor {

  private static final LessThanOperator instance = new LessThanOperator();

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
