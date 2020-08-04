# lld: low level design projects

## Execution
To execute and review the functionality, one could
1. Execute tests (with/without changes) <add href>
2. Use Main method <add href>
with supported attributes, operators and data types 

## Examples


## Supported user attributes
All combinations of 
* Map<String, Object>
* Map<String, Map<String, Object>>
* Map<String, Map<String, Map<String, Object>>>

and so on where Object should be 
* java equivalent of supported operator, or
* a Map<String, Object>
 
## Supported operators
 
## Supported data types

##Assumptions
1. Strings will be passed in double quotes, eg. "\"ABCD\""

2. Groups will be flat and no nested groups would be allowed.
    * "($category in (1,2,3) AND  age > 5) AND height <10" is allowed
    * "$category in (1,2,(4,3,5))" is NOT allowed
    
3. Supported types inside group are only literals and NOT Variables.
    
Variables
1. Variable names are already valid and available in massed map.
1. Variable names does not contain '#' and # is used to go inside next nested Map. 
    For example for Map<String, Map<String, Object>>, to access inner level Object the key would be
    <outerMapKey>#<innerMapKey>