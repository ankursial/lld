# lld: low level design projects

##Assumptions
1. Strings will be passed in double quotes, eg. "\"ABCD\""
2. Groups will be flat and no nested groups would be allowed.
    * "($category in (1,2,3) AND  age > 5) AND height <10" is allowed
    * "$category in (1,2,(4,3,5))" is NOT allowed
3. 

