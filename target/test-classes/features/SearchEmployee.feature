@SearchEmployee 
Feature: Search Employee

Background: 
    When user entered valid admin username and valid password
    And user click on login button
    Then user navigates to Add Employee Page
    
  Scenario: Search employee by ID
   
    And user logged in with valid login credentials
    And user navigated to Employee List
    When user enteres valid employee id
    And clicks Search button
    Then user see employee information is displayed

  Scenario: Search employee by name
   
    And user logged in with valid login credentials
    And user navigated to Employee List
    When user enteres valid employee name nad last name
    And clicks Search button
    Then user see employee information is displayed

     @smoke
    Scenario: Admin should be able to modify employee information
   When user should be able to modify employee personal details