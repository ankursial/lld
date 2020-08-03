package expression.evaluator.token;

import expression.evaluator.exception.InvalidTokenException;

public interface TokenExtractor {

  boolean startsWithSupportedToken(String expression, int startNdx);

  Token extractToken(String expression, int startNdx) throws InvalidTokenException;
}
