package expression.token.paenthesis;

import expression.token.fixedvalue.FixedValueTokenExtractor;

public abstract class ParenthesisExtractor extends FixedValueTokenExtractor {

  protected static int extractorPriority = 1;
}
