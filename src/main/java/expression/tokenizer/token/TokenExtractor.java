package expression.tokenizer.token;

import expression.tokenizer.exception.InvalidTokenException;

public interface TokenExtractor {

  boolean startsWithSupportedToken(String expression, int startNdx);

  Token extractToken(String expression, int startNdx) throws InvalidTokenException;
}
