# lld: low level design projects

## Intro
See https://github.com/ankursial/lld/blob/expression-evaluator/static%20files/Feature%20Gating%20module%20Assignment.pdf

## Class Diagrams
![Image 1](https://github.com/ankursial/lld/blob/expression-evaluator/UML%20diagrams/Class%20diagram%201-overview.png)
![Image 2](https://github.com/ankursial/lld/blob/expression-evaluator/UML%20diagrams/Class%20diagram%202-%20Tokens.png)
![Image 3](https://github.com/ankursial/lld/blob/expression-evaluator/UML%20diagrams/Class%20diagram%203-%20Tokenizers.png)

## Execution
To execute and review the functionality, one could
1. Use Main method with supported attributes, operators and data types 
: https://github.com/ankursial/lld/blob/expression-evaluator/src/main/java/expression/Main.java

1. Execute tests (with/without changes)
: https://github.com/ankursial/lld/blob/expression-evaluator/src/test/java/expression/evaluator/InfixExpressionEvaluateAndTest.java

1. Execute submodule wise tests
:  https://github.com/ankursial/lld/tree/expression-evaluator/src/test/java/expression

## Examples expressions
#### Example 1
    Map<String, Object> addressMap = new HashMap<>();
    addressMap.put("pincode", 110060);
    Map<String, Object> userMap = new HashMap<>();
    userMap.put("noOfOrders", 15);
    userMap.put("age", 15);
    userMap.put("address", addressMap);

    String input = " 5 < noOfOrders AND address#pincode < 200000 AND 30 < age";

#### Example 2
    String input = "10 < 15 AND 10 NONEOF (10,20,30)";

#### Example 3
    String input = "(5 < 10 AND 10 < 15) AND 5 NONEOF (10,20,30)";

#### Example 4
    String input = "15 < 10";


## Supported user attributes
All combinations of 
* Map<String, Object>
* Map<String, Map<String, Object>>
* Map<String, Map<String, Map<String, Object>>>

and so on where Object should be 
* java equivalent of supported operator, or
* a Map<String, Object>
 
## Supported operators
1. LessThan: "<"
1. NONEOF: "variable NONEOF (1,2,3)"
1. AND: "30 < age AND variable NONEOF (1,2,3)"

Note: Others not added to keep PR simple and are similar to ones added above.
 
## Supported data types
1. Boolean: true/false
1. Integer
1. String

Note: Others not added to keep PR simple and are similar to ones added above. 

For variables,use map. 
For example see Main: https://github.com/ankursial/lld/blob/expression-evaluator/src/main/java/expression/Main.java
 
## Assumptions
1. Strings will be passed in double quotes, eg. "\\"ABCD\\""

2. Groups will be flat and no nested groups would be allowed.
    * "($category in (1,2,3) AND  age > 5) AND height <10" is allowed
    * "$category in (1,2,(4,3,5))" is NOT allowed
    
3. Supported types inside group are only literals and NOT Variables.
    
Variables
1. Variable names are already valid and available in massed map.
1. Variable names does not contain '#' and # is used to go inside next nested Map. 
    For example for Map<String, Map<String, Object>>, to access inner level Object the key would be
    <outerMapKey>#<innerMapKey>