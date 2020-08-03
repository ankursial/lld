package expression.evaluator.tokenizer;

import expression.evaluator.token.TokenExtractor;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TokenizerRegistry {

  private static final NavigableMap<Integer, Set<TokenExtractor>> memory = new TreeMap<>();

  public static void register(TokenExtractor toBeRegisteredClass, int priority) {
    if (!memory.containsKey(priority)) {
      memory.put(priority, new HashSet<>());
    }

    memory.get(priority).add(toBeRegisteredClass);
  }

  public static NavigableMap<Integer, Set<TokenExtractor>> getTokenClassesWithPriority() {
    return memory; //todo deep clone
  }
}
