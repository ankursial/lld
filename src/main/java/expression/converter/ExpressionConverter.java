package expression.converter;

import expression.tokenizer.exception.InvalidTokenException;
import expression.tokenizer.token.Token;
import java.util.List;

public interface ExpressionConverter {

  List<Token> convert(List<Token> inputExpressionList) throws InvalidTokenException;
}
