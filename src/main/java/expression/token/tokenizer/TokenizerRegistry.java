package expression.token.tokenizer;

import expression.token.operand.BooleanOperandExtractor;
import expression.token.operand.StringOperandExtractor;
import expression.token.operand.number.IntegerOperandExtractor;
import expression.token.operand.variable.VariableOperandExtractor;
import expression.token.operator.AndOperatorExtractor;
import expression.token.operator.LessThanOperatorExtractor;
import expression.token.operator.NoneOfOperatorExtractor;
import expression.token.paenthesis.LeftParenthesisExtractor;
import expression.token.paenthesis.RightParenthesisExtractor;
import expression.token.token.TokenExtractor;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TokenizerRegistry {

  private static final NavigableMap<Integer, Set<TokenExtractor>> memory = new TreeMap<>();

  static {
    register(new LeftParenthesisExtractor(), 1);
    register(new RightParenthesisExtractor(), 1);

    register(new LessThanOperatorExtractor(), 2);
    register(new NoneOfOperatorExtractor(), 2);
    register(new AndOperatorExtractor(), 2);

    register(new BooleanOperandExtractor(), 3);

    register(new VariableOperandExtractor(), 4);
    register(new IntegerOperandExtractor(), 4);
    register(new StringOperandExtractor(), 4);
  }

  private static void register(TokenExtractor toBeRegisteredClass, int priority) {
    if (!memory.containsKey(priority)) {
      memory.put(priority, new HashSet<>());
    }

    memory.get(priority).add(toBeRegisteredClass);
  }

  public static NavigableMap<Integer, Set<TokenExtractor>> getTokenClassesWithPriority() {
    return memory; //todo deep clone
  }
}
