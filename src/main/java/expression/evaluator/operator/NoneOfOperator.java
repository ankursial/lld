package expression.evaluator.operator;

public class NoneOfOperator extends Operator {

  private final String value = "NONEOF";

  @Override
  public String getStringValue() {
    return value;
  }
}
