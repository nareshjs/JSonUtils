# JSonUtils
Trying to convert POJO to JSON using Jackson APIs
Also trying to filter out some POJO attributes which need to be skipped for JSON conversion. Tried the following approaches:
1. Using @JsonFilter - when you have write access to the POJO
2. Using custom serialization - when you dont have write access to the POJO
