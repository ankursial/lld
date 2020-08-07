package expression;

import expression.myexception.InvalidEvaluationException;
import expression.myexception.InvalidTokenException;
import expression.myexception.UnsupportedOperandException;
import expression.service.ExpressionService;
import expression.service.ExpressionServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {

  private static final ExpressionService expressionService = new ExpressionServiceImpl();

  public static void main(String[] args) {
    Map<String, Object> addressMap = new HashMap<>();
    addressMap.put("pincode", 110060);
    Map<String, Object> userMap = new HashMap<>();
    userMap.put("noOfOrders", 15);
    userMap.put("age", 60);
    userMap.put("address", addressMap);

    String conditionalExpression = " 5 < noOfOrders AND address#pincode < 200000 AND 30 < age";
    processConditionalExpression(userMap, conditionalExpression);
  }

  private static void processConditionalExpression(Map<String, Object> userMap,
      String conditionalExpression) {
    try {
      boolean result = expressionService.isAllowed(conditionalExpression, userMap);
      System.out.println("User: " + userMap);
      System.out.println("Input expression: " + conditionalExpression);
      System.out.println("Evaluation Result: " + result);
    } catch (InvalidEvaluationException e) {
      System.out.println("InvalidEvaluationException" + e.getMessage());
    } catch (UnsupportedOperandException e) {
      System.out.println("UnsupportedOperandException" + e.getMessage());
    } catch (InvalidTokenException e) {
      System.out.println("InvalidTokenException" + e.getMessage());
    }
  }
}
