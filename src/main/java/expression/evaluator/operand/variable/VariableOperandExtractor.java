package expression.evaluator.operand.variable;

import expression.evaluator.exception.InvalidTokenException;
import expression.evaluator.token.Token;
import expression.evaluator.token.TokenExtractor;
import expression.evaluator.tokenizer.TokenizerRegistry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableOperandExtractor implements TokenExtractor {

  protected static int extractorPriority = 3;

  static {
    TokenizerRegistry.register(new VariableOperandExtractor(), extractorPriority);
  }

  @Override
  public boolean startsWithSupportedToken(String expression, int startNdx) {
    final String regex = "^[a-zA-Z_$]";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    return matcher.find();
  }

  @Override
  public Token extractToken(String expression, int startNdx) throws InvalidTokenException {
    final String regex = "[a-zA-Z_$](\\.?[a-zA-Z_0-9$])*";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(expression.substring(startNdx));
    if (matcher.find()) {
      return new VariableOperand(matcher.group());
    }

    throw new InvalidTokenException(
        "Invalid integer token:" + expression.charAt(startNdx)
            + ", match at index: " + startNdx
            + ", for expression:" + expression);
  }

}
