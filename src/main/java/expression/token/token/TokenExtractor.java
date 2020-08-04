package expression.token.token;

import expression.myexception.InvalidTokenException;

public interface TokenExtractor {

  boolean startsWithSupportedToken(String expression, int startNdx);

  Token extractToken(String expression, int startNdx) throws InvalidTokenException;
}
