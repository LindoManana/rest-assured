# Rest-Assured
This is a spring boot project that shows the basic usage of Rest-Assured for API testing. 

### Overview
 REST-assured was designed to simplify the testing and validation of REST APIs. It is a really powerful catalyzer for automated testing of REST-services. The library has solid support for HTTP, starting of course with the verbs and standard HTTP operations, but also going well beyond these basics.

### Project Test Cases
This project contains the following test cases::
**1. testCreateEmployee:**
- **Test case description:** Tests the creation of an employee resource. In this example, REST Assured will serialize the employee object to JSON since the request content-type is set to "application/json".
- **Test case expected result:** Verify the HTTP response status code returned is 201.

**2. testGetAllEmployees:**
 - **Test case description:** Test whether API fetches all employees.
 
- **Test case expected result:** Verify the HTTP response status code returned is 200.

**3. testGetEmployeeById:**
 - **Test case description:** Test whether API fetches an employee by id.
 
- **Test case expected result:** Validate that the response body contains a JSON String, and the returned employee "firstName" is equal to "Elon".

**4. testUpdateEmployee:**
 - **Test case description:** Test whether API updates an existing employee. In this example, I update the employee's "location" from "South Africa" to "USA".
 
- **Test case expected result:** Validate that response body contains JSON String, and the employee's "location" field value is now "USA".

**5. testDeleteEmployee:**
 - **Test case description:** Test whether API deletes an employee.
 
- **Test case expected result:** Verify the HTTP response status code returned is 200.



### Built With
* [Spring Boot](https://spring.io/projects/spring-boot) - Java-based framework.
* [Rest-Assured](http://rest-assured.io/) - API testing framework.
* [JUnit 5](https://junit.org/junit5/) - Unit-testing framework.
* [Maven](https://maven.apache.org/) - Dependency Management.