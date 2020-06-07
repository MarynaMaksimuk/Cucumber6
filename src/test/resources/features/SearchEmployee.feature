@SearchEmployee @sprint13
Feature: Employee Search

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
