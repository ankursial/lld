package expression.service;

import expression.myexception.UnsupportedOperandException;
import expression.token.operand.BooleanOperand;
import expression.token.operand.Operand;
import expression.token.operand.StringOperand;
import expression.token.operand.number.IntegerOperand;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class OperandFactory {

  private static final Map<Class, Function<Object, Operand>> converters;

  static {
    converters = new HashMap<>();
    converters.put(String.class, object -> new StringOperand(object.toString()));
    converters.put(Integer.class, object -> new IntegerOperand(object.toString()));
    converters.put(Boolean.class, object -> new BooleanOperand(object.toString()));
  }

  public Operand getOperand(Object object) throws UnsupportedOperandException {

    if (converters.containsKey(object.getClass())) {
      return converters.get(object.getClass()).apply(object);
    }

    throw new UnsupportedOperandException("operand not supported " + object.getClass());
  }

}
