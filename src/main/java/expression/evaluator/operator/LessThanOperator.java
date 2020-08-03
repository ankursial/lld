package expression.evaluator.operator;

public class LessThanOperator extends Operator {

  private final String value = "<";

  @Override
  public String getStringValue() {
    return value;
  }
}
