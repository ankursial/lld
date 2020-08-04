package expression.service;

import java.util.Map;

public class UserServiceImpl implements UserService {

  Map<String, Object> userMap;

  public UserServiceImpl(Map<String, Object> userMap) {
    this.userMap = userMap;
  }

  @Override
  public Object getJavaObject(String variable) {
    String[] userMapKeys = variable.split("#");
    Map<String, Object> currMap = userMap;
    for (int ndx = 0; ndx < userMapKeys.length - 1; ndx++) {
      currMap = (Map<String, Object>) currMap.get(userMapKeys[ndx]);
    }
    return currMap.get(userMapKeys[userMapKeys.length - 1]);
  }
}
