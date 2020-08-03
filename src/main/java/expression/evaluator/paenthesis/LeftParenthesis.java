package expression.evaluator.paenthesis;

public class LeftParenthesis extends Parenthesis {

  private final String value = "(";

  @Override
  public String getStringValue() {
    return value;
  }
}
