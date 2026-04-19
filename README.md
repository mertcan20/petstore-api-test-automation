# Petstore API Test Automation

This project demonstrates automated API testing using **Java, RestAssured, TestNG, and Maven**.
The tests validate CRUD operations of the **Swagger Petstore API** and include response validation, header checks, and response time assertions.

---

## Technologies

* Java 17
* RestAssured
* TestNG
* Maven

---

## Test Coverage

The automation suite includes the following API tests:

* **Create Pet (POST)** – Creates a new pet in the system
* **Get Pet by ID (GET)** – Retrieves the created pet
* **Update Pet (PUT)** – Updates pet information
* **Delete Pet (DELETE)** – Deletes the pet from the system

These tests simulate a full **CRUD lifecycle** for the API.

---

## Assertions

The tests include multiple validation points:

* Status code validation
* Response body validation
* Header validation
* Response time validation

---

## API Used

Swagger Petstore API

https://petstore.swagger.io

---

## Run Tests

Run the test suite using Maven:

```
mvn clean test
```

Tests can also be executed via **TestNG suite** using the `testng.xml` file.

---

## Project Structure

```
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
```

---

## Purpose

The goal of this project is to demonstrate a **basic API test automation framework** using modern QA automation tools.
It showcases how automated tests can validate REST API endpoints and ensure reliability through automated assertions.

This repository can serve as a **portfolio project for QA Automation / SDET roles**.
