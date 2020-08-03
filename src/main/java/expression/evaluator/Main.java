package expression.evaluator;

import expression.evaluator.exception.InvalidTokenException;
import expression.evaluator.operand.number.IntegerOperandExtractor;
import expression.evaluator.operator.LessThanOperatorExtractor;
import expression.evaluator.paenthesis.LeftParenthesisExtractor;
import expression.evaluator.paenthesis.RightParenthesisExtractor;
import expression.evaluator.token.Token;
import expression.evaluator.tokenizer.Tokenizer;
import java.util.List;

public class Main {

  private static void simulateDependencyInjection() {
    LeftParenthesisExtractor leftParenthesisExtractor = new LeftParenthesisExtractor();
    RightParenthesisExtractor rightParenthesisExtractor = new RightParenthesisExtractor();
    LessThanOperatorExtractor lessThanOperatorExtractor = new LessThanOperatorExtractor();
    IntegerOperandExtractor integerOperandExtractor = new IntegerOperandExtractor();
  }

  public static void main(String[] args) throws InvalidTokenException {
    //simulating calling all TokenMappers, probably by a DI engine
    simulateDependencyInjection();

    String input = "(( ( < < 5 < 10)";
    System.out.println("input: " + input);
    List<Token> result = Tokenizer.tokenize(input);
    System.out.println(result);
  }
}
