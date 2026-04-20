# Petstore API Test Automation

This project demonstrates automated API testing using **Java, RestAssured, TestNG, and Maven**.  
The tests validate CRUD operations of the Swagger Petstore API and include response validation, header checks, and response time assertions.

---

## Features

- REST API automation using RestAssured
- CRUD API testing (Create, Read, Update, Delete)
- POJO model based request building
- TestNG based test execution
- Maven dependency management
- JSON serialization using Jackson
- Response validation and performance checks

---

## Technologies Used

- Java 17
- RestAssured
- TestNG
- Maven
- Jackson Databind

---

## Test Coverage

The automation suite includes the following API tests:

### Create Pet (POST)
Creates a new pet in the system.

### Get Pet by ID (GET)
Retrieves the created pet and validates response content.

### Update Pet (PUT)
Updates the existing pet information.

### Delete Pet (DELETE)
Deletes the pet from the system and verifies removal.

These tests simulate a full **CRUD lifecycle for the API**.

---

## Assertions

The tests include multiple validation points:

- Status code validation
- Status line validation
- Response body validation
- Header validation
- Response time validation

---

## API Used

Swagger Petstore API

https://petstore.swagger.io/

---

