package expression.evaluator.paenthesis;

import expression.evaluator.fixedvalue.FixedValueTokenExtractor;

public abstract class ParenthesisExtractor extends FixedValueTokenExtractor {

  protected static int extractorPriority = 1;
}
