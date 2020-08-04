package expression.converter;

import expression.myexception.InvalidTokenException;
import expression.token.token.Token;
import java.util.List;

public interface ExpressionConverter {

  List<Token> convert(List<Token> inputExpressionList) throws InvalidTokenException;
}
