package expression.tokenizer;

import expression.myexception.InvalidTokenException;
import expression.token.token.Token;
import expression.token.token.TokenExtractor;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

public class Tokenizer {

  public static List<Token> tokenize(String expression) throws InvalidTokenException {
    List<Token> finalTokenList = new ArrayList<>();

    NavigableMap<Integer, Set<TokenExtractor>> tokenClassesPriorityMap =
        TokenizerRegistry.getTokenClassesWithPriority();

    NavigableSet<Integer> tokenClassPrioritySet = tokenClassesPriorityMap.navigableKeySet();

    for (int currNdx = 0; currNdx < expression.length(); ) {

      // skip spaces
      if (expression.charAt(currNdx) == ' ' || expression.charAt(currNdx) == ',') {
        currNdx++;
        continue;
      }

      Token token = getNextToken(expression, currNdx, tokenClassesPriorityMap,
          tokenClassPrioritySet);
      finalTokenList.add(token);
      currNdx += token.getStringLength();
      //check for PARENTHESIS

      //todo check for LIST

      //todo check for RANGE

      //check for OPERATORS

      //check for Strings

      //check for variables

      //check for numbers
    }
    return finalTokenList;
  }

  private static Token getNextToken(String expression, int currNdx,
      NavigableMap<Integer, Set<TokenExtractor>> tokenClassesPriorityMap,
      NavigableSet<Integer> tokenClassPrioritySet) throws InvalidTokenException {
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
