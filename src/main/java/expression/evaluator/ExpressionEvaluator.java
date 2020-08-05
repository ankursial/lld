package expression.evaluator;

import expression.myexception.InvalidEvaluationException;
import expression.token.operand.Operand;
import expression.token.Token;
import java.util.List;

public interface ExpressionEvaluator {

  Operand evaluate(List<Token> postFixExpression) throws InvalidEvaluationException;
}
