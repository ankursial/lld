package expression.token.operand;

import expression.myexception.InvalidTokenException;
import expression.token.token.Token;
import expression.token.token.TokenExtractor;
import expression.tokenizer.Tokenizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListOperandExtractor implements TokenExtractor {

  final String regex = "^\\( *((?:(?:[\"0-9A-Za-z]+)* *, *)* *(?:[\"0-9A-Za-z]+)) *\\)";

  @Override
  public boolean startsWithSupportedToken(String expression, int startNdx) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    if (matcher.find()) {
      return true;
    }
    return false;
  }

  @Override
  public Token extractToken(String expression, int startNdx) throws InvalidTokenException {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    if (matcher.find()) {
      List<Token> groupTokens = Tokenizer.tokenize(matcher.group(1));
      return new ListOperand(matcher.group(), groupTokens);
    }

    throw new InvalidTokenException(
        "Invalid integer token:" + expression.charAt(startNdx)
            + ", match at index: " + startNdx
            + ", for expression:" + expression);
  }

}
