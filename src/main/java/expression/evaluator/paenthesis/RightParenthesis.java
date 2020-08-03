package expression.evaluator.paenthesis;

public class RightParenthesis extends Parenthesis {

  private final String value = ")";

  @Override
  public String getStringValue() {
    return value;
  }
}
