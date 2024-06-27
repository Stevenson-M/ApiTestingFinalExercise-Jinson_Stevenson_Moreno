# api-automation-final-exercise

## API link
- [Endpoint](https://637bbb6b6f4024eac217041a.mockapi.io/users)
- [Project](https://mockapi.io/projects/637bbb6b6f4024eac217041b)
- [Clone](https://mockapi.io/clone/637bbb6b6f4024eac217041b)

## Considerations
- The tests must be executed from the "Suite.xml" file, because of the endpoint being handled as a parameter.
- In general, the tests could take a lot of time at being performed due to the *mockAPI* response speed, which could drop at some moments during the day.
- [java-faker](https://github.com/DiUS/java-faker) dependency is being used for the random data generation.

### Empty endpoint test
If there are above 30 users to be deleted in the endpoint, the test might fail due to 429 status. However, the test will inform about which users were not deleted.

### Initialize pojo test
Since one of the users will have a duplicate email in purpose, 11 users are originally created with random data, in order to ensure 10 of them will be created in the endpoint.

### Verify duplicate test
No additional considerations are needed.

### Update user test
- By default, the user to be updated will be the one with id = 1; in case it is chosen another user to be updated, the attribute "userId" in "UpdateUserTest.java" file must be changed.
- It will fail if the endpoint is empty.

### 
Final project API Testing Author: Stevenson Moreno This project is about testing an API, related to a bank transaction. The URL for the project is: "https://637bdb6472f3ce38ea969c93.mockapi.io/BankInfoApi/Bank"

The endpoint was defined as a parameter in the suite, so all the tests must be executed from this file, "Suite.xml"

The test carried out in the project are the followings:
 -  @Test 1 > Verify the Endpoint is empty and If it has any data use a delete request to leave it empty) 
 -  @Test 2 > Initialize the POJO with 10 random data and verify there is no duplicate email accounts, send the POST request with the POJO. 
 -  @Test 3 >GET request verifying that there are no duplicate emails. @Test 4 > Update an existing AccountNumber.
