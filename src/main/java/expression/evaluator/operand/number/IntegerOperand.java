package expression.evaluator.operand.number;

public class IntegerOperand extends NumberOperand {

  private final String value;

  public IntegerOperand(String value) {
    this.value = value;
  }

  @Override
  public String getStringValue() {
    return value;
  }
}
