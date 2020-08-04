package expression.tokenizer.paenthesis;

import expression.tokenizer.fixedvalue.FixedValueTokenExtractor;

public abstract class ParenthesisExtractor extends FixedValueTokenExtractor {

  protected static int extractorPriority = 1;
}
