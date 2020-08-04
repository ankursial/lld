package expression.token.operator;

import expression.token.fixedvalue.FixedValueTokenExtractor;

public abstract class OperatorExtractor extends FixedValueTokenExtractor {

  protected static int extractorPriority = 2;
}
