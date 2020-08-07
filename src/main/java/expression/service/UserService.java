package expression.service;

import java.util.Map;

public interface UserService {

  Object getJavaObject(String key);

  void setUser(Map<String, Object> userMap);
}
