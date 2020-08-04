package expression.tokenizer.operand.variable;

import expression.tokenizer.exception.InvalidTokenException;
import expression.tokenizer.token.Token;
import expression.tokenizer.token.TokenExtractor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableOperandExtractor implements TokenExtractor {

  protected static int extractorPriority = 3;

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
