package expression.tokenizer;

import expression.tokenizer.exception.InvalidTokenException;
import expression.tokenizer.token.Token;
import expression.tokenizer.tokenizer.Tokenizer;
import java.util.List;

public class Main {

  public static void main(String[] args) throws InvalidTokenException {
    String input = "(5 < 10) AND abx \"$variable\" NONEOF (5,10,15) true False True FaLsE 2 Hello";
    System.out.println("input: " + input);
    List<Token> result = Tokenizer.tokenize(input);
    System.out.println(result);
  }
}
