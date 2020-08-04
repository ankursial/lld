package expression.tokenizer.operator;

import expression.tokenizer.fixedvalue.FixedValueTokenExtractor;

public abstract class OperatorExtractor extends FixedValueTokenExtractor {

  protected static int extractorPriority = 2;
}
