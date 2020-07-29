Feature: Systan HRMS API End to End Workflow

  Background: 
    Given a JWT is generated

  
  Scenario: Creating an employee
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee is created
    And the employee ID is stored as a global variable to be used for other calls

    Scenario: Retrieving created employee
    Given a requast is prepared to retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for retrieving the created employee is 200
    And the retrieved employee ID matches the globaly stored employee ID
    And the retrieved data matches the data used to create an employee
    