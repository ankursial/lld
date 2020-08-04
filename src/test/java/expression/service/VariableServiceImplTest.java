package expression.service;

import expression.myexception.UnsupportedOperandException;
import expression.token.operand.Operand;
import expression.token.operand.StringOperand;
import expression.token.operand.number.IntegerOperand;
import expression.token.operand.variable.VariableOperand;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class VariableServiceImplTest {

  @Test
  void replaceVariablesWithOperandsTest() throws UnsupportedOperandException {

    Map<String, Object> addressMap = new HashMap<>();
    addressMap.put("city", "noida");
    addressMap.put("state", "UP");
    addressMap.put("pincode", 110060);

    Map<String, Object> userMap = new HashMap<>();
    userMap.put("age", 5);
    userMap.put("lastOrderAmount", 1000);
    userMap.put("address", addressMap);

    UserService userService = new UserServiceImpl(userMap);
    VariableService variableService = new VariableServiceImpl(userService);

    List<Operand> variablesAndOperands = new ArrayList<>();
    variablesAndOperands.add(new StringOperand("ThisIsPlainStringOperand"));
    variablesAndOperands.add(new VariableOperand("age"));
    variablesAndOperands.add(new VariableOperand("lastOrderAmount"));
    variablesAndOperands.add(new VariableOperand("address#city"));
    variablesAndOperands.add(new VariableOperand("address#pincode"));

    List<Operand> expectedList = new ArrayList<>();
    expectedList.add(new StringOperand("ThisIsPlainStringOperand"));
    expectedList.add(new IntegerOperand("5"));
    expectedList.add(new IntegerOperand("1000"));
    expectedList.add(new StringOperand("noida"));
    expectedList.add(new IntegerOperand("110060"));

    //process
    List<Operand> operandWithReplacedVariables =
        variableService.replaceVariablesWithOperands(variablesAndOperands);

    Assert.assertEquals(expectedList, operandWithReplacedVariables);
  }
}
