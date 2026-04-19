# Petstore API Test Automation

This project demonstrates automated API testing using **Java, RestAssured, TestNG and Maven**.

## Technologies

* Java 17
* RestAssured
* TestNG
* Maven

## Test Coverage

* Create Pet (POST)
* Get Pet by ID (GET)
* Update Pet (PUT)
* Delete Pet (DELETE)

## Assertions

* Status code validation
* Response body validation
* Header validation
* Response time validation

## API Used

Swagger Petstore API
https://petstore.swagger.io

## Run Tests

Run the test suite using Maven:

mvn clean test

## Project Structure

petstore-api-test-automation
│
├── pom.xml
├── testng.xml
├── README.md
│
└── src
  └── test
    └── java
      └── requests
        └── ApiTests.java
