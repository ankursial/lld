package expression.tokenextractor.operator;

import expression.token.FixedValueToken;
import expression.token.operator.AndOperator;

public class AndOperatorExtractor extends AbstractOperatorExtractor {

  private static final AndOperator instance = new AndOperator();

  @Override
  protected FixedValueToken getToken() {
    return instance;
  }
}
