package expression.evaluator;

import expression.myexception.InvalidEvaluationException;
import expression.token.operand.AbstractOperand;
import expression.token.Token;
import java.util.List;

public interface ExpressionEvaluator {

  AbstractOperand evaluate(List<Token> postFixExpression) throws InvalidEvaluationException;
}
