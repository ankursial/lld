package expression.service;

import expression.myexception.InvalidEvaluationException;
import expression.myexception.InvalidTokenException;
import expression.myexception.UnsupportedOperandException;
import java.util.Map;

public interface ExpressionService {

  boolean isAllowed(String conditionalExpression, Map<String, Object> user)
      throws InvalidEvaluationException, InvalidTokenException, UnsupportedOperandException;
}
