package expression.evaluator.operand.number;

import expression.evaluator.exception.InvalidTokenException;
import expression.evaluator.token.Token;
import expression.evaluator.tokenizer.TokenizerRegistry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerOperandExtractor extends NumberOperandExtractor {

  static {
    TokenizerRegistry.register(new IntegerOperandExtractor(), extractorPriority);
  }

  @Override
  public Token extractToken(String expression, int startNdx) throws InvalidTokenException {
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    if (matcher.find()) {
      return new IntegerOperand(matcher.group());
    }

    throw new InvalidTokenException(
        "Invalid integer token:" + expression.charAt(startNdx)
            + ", match at index: " + startNdx
            + ", for expression:" + expression);
  }
}
