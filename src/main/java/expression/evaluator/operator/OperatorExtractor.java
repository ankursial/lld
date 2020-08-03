package expression.evaluator.operator;

import expression.evaluator.fixedvalue.FixedValueTokenExtractor;

public abstract class OperatorExtractor extends FixedValueTokenExtractor {

  protected static int extractorPriority = 2;
}
