package expression.converter;

import expression.myexception.InvalidTokenException;
import expression.token.operator.AbstractOperator;
import expression.token.Token;
import expression.token.TokenType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfixConverter implements ExpressionConverter {

  /**
   * Reference http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm
   *
   * @param inputExpressionList
   * @return
   * @throws InvalidTokenException
   */
  @Override
  public List<Token> convert(List<Token> inputExpressionList) throws InvalidTokenException {
    List<Token> postFixResult = new ArrayList<>();

    Stack<Token> operatorStack = new Stack<>();

    for (Token token : inputExpressionList) {

      switch (token.getTokenType()) {
        case OPERAND:
          postFixResult.add(token);
          break;
        case LEFT_PARENTHESIS:
          operatorStack.push(token);
          break;
        case RIGHT_PARENTHESIS:
          processRightParenthesis(postFixResult, operatorStack, token);
          break;
        case OPERATOR:
          if (operatorStack.isEmpty()
              || isLeftParenthesisAtTop(operatorStack)) {
            operatorStack.push(token);
            continue;
          }

          AbstractOperator curr_operator = (AbstractOperator) token;
          while (!operatorStack.isEmpty()
              && !isLeftParenthesisAtTop(operatorStack)
              && isPrecedenceHigher(curr_operator, (AbstractOperator) operatorStack.peek())) {
            postFixResult.add(operatorStack.pop());
          }
          operatorStack.push(curr_operator);
      }
    }
    while (!operatorStack.isEmpty()) {
      //Pop the stack and add the popped value to postFixResult
      Token token = operatorStack.pop();
      if (isParenthesis(token)) {
        throw new InvalidTokenException("Invalid parenthesis " + token.getClass() + " " + token
            + "expected LeftParenthesis");
      }
      postFixResult.add(token);
    }

    return postFixResult;
  }

  private boolean isPrecedenceHigher(
      AbstractOperator curr_operator, AbstractOperator stackTopOperator) {
    return curr_operator.getPrecedence() <= stackTopOperator.getPrecedence();
  }

  private boolean isParenthesis(Token token) {
    return token.getTokenType().equals(TokenType.LEFT_PARENTHESIS)
        || token.getTokenType().equals(TokenType.RIGHT_PARENTHESIS);
  }

  private boolean isLeftParenthesisAtTop(Stack<Token> operatorStack) {
    return operatorStack.peek().getTokenType().equals(TokenType.LEFT_PARENTHESIS);
  }

  private void processRightParenthesis(List<Token> p, Stack<Token> operatorStack, Token token)
      throws InvalidTokenException {
    while (!operatorStack.isEmpty()
        && !(isLeftParenthesisAtTop(operatorStack))) {
      p.add(operatorStack.pop());
    }

    //discard left parenthesis
    Token expectedLeftParenthesis = operatorStack.pop();
    if (!expectedLeftParenthesis.getTokenType().equals(TokenType.LEFT_PARENTHESIS)) {
      throw new InvalidTokenException("Invalid token " + token.getClass() + token
          + "expected LeftParenthesis");
    }
  }
}
