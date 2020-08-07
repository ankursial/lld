package expression.tokenizer;

import expression.tokenextractor.operand.BooleanOperandExtractor;
import expression.tokenextractor.operand.ListOperandExtractor;
import expression.tokenextractor.operand.StringOperandExtractor;
import expression.tokenextractor.operand.IntegerOperandExtractor;
import expression.tokenextractor.operand.VariableOperandExtractor;
import expression.tokenextractor.operator.AndOperatorExtractor;
import expression.tokenextractor.operator.LessThanOperatorExtractor;
import expression.tokenextractor.operator.NoneOfOperatorExtractor;
import expression.tokenextractor.parenthesis.LeftParenthesisExtractor;
import expression.tokenextractor.parenthesis.RightParenthesisExtractor;
import expression.tokenextractor.TokenExtractor;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TokenizerRegistry {

  private static final NavigableMap<Integer, Set<TokenExtractor>> memory = new TreeMap<>();

  static {
    register(new ListOperandExtractor(), 0);

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
