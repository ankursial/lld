package expression.token.operand;

import expression.token.Token;
import java.util.List;
import java.util.Objects;

public class ListOperand extends AbstractOperand {

  String value;
  List<Token> groupTokens;

  public ListOperand(String value, List<Token> groupTokens) {
    this.value = value;
    this.groupTokens = groupTokens;
  }

  @Override
  public OperandType getOperandType() {
    return OperandType.LIST;
  }

  @Override
  public int getStringLength() {
    return value.length();
  }

  @Override
  public String toString() {
    return "ListOperand{" +
        "value='" + value + '\'' +
        '}';
  }

  public List<Token> getGroupTokens() {
    return groupTokens;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ListOperand)) {
      return false;
    }
    ListOperand that = (ListOperand) o;
    return Objects.equals(value, that.value) &&
        groupTokens.equals(that.groupTokens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
