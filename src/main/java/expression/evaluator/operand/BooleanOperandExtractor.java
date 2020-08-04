package expression.evaluator.operand;

import expression.evaluator.exception.InvalidTokenException;
import expression.evaluator.token.Token;
import expression.evaluator.token.TokenExtractor;
import expression.evaluator.tokenizer.TokenizerRegistry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooleanOperandExtractor implements TokenExtractor {

  protected static int extractorPriority = 3;

  static {
    TokenizerRegistry.register(new BooleanOperandExtractor(), extractorPriority);
  }

  @Override
  public boolean startsWithSupportedToken(String expression, int startNdx) {
    final String regex = "(?i)(true|false)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    return matcher.find();
  }

  @Override
  public Token extractToken(String expression, int startNdx) throws InvalidTokenException {
    final String regex = "(?i)(true|false)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    if (matcher.find()) {
      return new BooleanOperand(matcher.group());
    }

    throw new InvalidTokenException(
        "Invalid integer token:" + expression.charAt(startNdx)
            + ", match at index: " + startNdx
            + ", for expression:" + expression);
  }

}
