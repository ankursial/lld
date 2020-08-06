package expression.tokenizer;

import expression.myexception.InvalidTokenException;
import expression.token.Token;
import expression.tokenextractor.TokenExtractor;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

public class TokenizerImpl implements Tokenizer {

  private final NavigableMap<Integer, Set<TokenExtractor>> tokenClassesPriorityMap =
      TokenizerRegistry.getTokenClassesWithPriority();

  private final NavigableSet<Integer> tokenClassPrioritySet =
      tokenClassesPriorityMap.navigableKeySet();

  public List<Token> tokenize(String expression) throws InvalidTokenException {
    List<Token> finalTokenList = new ArrayList<>();

    for (int currNdx = 0; currNdx < expression.length(); ) {

      // skip spaces and commas
      if (expression.charAt(currNdx) == ' ' || expression.charAt(currNdx) == ',') {
        currNdx++;
        continue;
      }

      Token token = getNextToken(expression, currNdx);
      finalTokenList.add(token);
      currNdx += token.getStringLength();
    }
    return finalTokenList;
  }

  private Token getNextToken(String expression, int currNdx) throws InvalidTokenException {
    for (Integer priority : tokenClassPrioritySet) {
      Set<TokenExtractor> tokenExtractors = tokenClassesPriorityMap.get(priority);
      for (TokenExtractor tokenExtractor : tokenExtractors) {
        if (tokenExtractor.startsWithSupportedToken(expression, currNdx)) {
          return tokenExtractor.extractToken(expression, currNdx);
        }
      }
    }
    throw new InvalidTokenException(
        "Invalid token:" + expression.charAt(currNdx)
            + ", at index:" + currNdx
            + ", for expression:" + expression);
  }
}
