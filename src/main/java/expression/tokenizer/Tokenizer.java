package expression.tokenizer;

import expression.myexception.InvalidTokenException;
import expression.token.Token;
import java.util.ArrayList;
import java.util.List;

public interface Tokenizer {

  List<Token> tokenize(String expression) throws InvalidTokenException;
}
