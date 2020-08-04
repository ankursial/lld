package expression.evaluator;

import expression.myexception.InvalidEvaluationException;
import expression.token.operand.Operand;
import expression.token.operator.Operator;
import expression.token.token.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixExpressionEvaluator implements ExpressionEvaluator {

  /**
   * Refernece http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm
   *
   * @param postFixExpression
   * @return
   * @throws InvalidEvaluationException
   */
  @Override
  public Operand evaluate(List<Token> postFixExpression) throws InvalidEvaluationException {
    Stack<Token> operandStack = new Stack<>();

    for (Token token : postFixExpression) {
      switch (token.getTokenType()) {
        case OPERAND:
          operandStack.push(token);
          break;
        case OPERATOR:
          performOperatorOperation(operandStack, (Operator) token);
          break;
        default:
          throw new InvalidEvaluationException("Invalid token");
      }
    }

    if (operandStack.size() == 1) {
      return (Operand) operandStack.pop();
    } else {
      throw new InvalidEvaluationException("Invalid operandStack. Size should be 1.");
    }
  }

  private void performOperatorOperation(Stack<Token> operandStack, Operator token)
      throws InvalidEvaluationException {
    Operator operator = token;
    int reqdOperands = operator.getRequiredOperandCount();
    List<Operand> operands = new ArrayList<>();
    while (!operandStack.isEmpty() && reqdOperands-- > 0) {
      operands.add((Operand) operandStack.pop());
    }
    if (reqdOperands > 0) {
      throw new InvalidEvaluationException(
          "Invalid postFixExpression. Could not get required operands");
    }
    Operand result = operator.apply(operands);
    operandStack.push(result);
  }
}
