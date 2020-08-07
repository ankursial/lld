package expression.tokenextractor;

import expression.myexception.InvalidTokenException;
import expression.token.Token;

public interface TokenExtractor {

  boolean startsWithSupportedToken(String expression, int startNdx);

  Token extractToken(String expression, int startNdx) throws InvalidTokenException;
}
