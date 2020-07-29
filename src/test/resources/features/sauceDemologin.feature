#Author: reihan
Feature: Sause Demo feature

  Scenario: invalid Login
    Given user is on login page
    When user enter invalid username
    And user enter invalid password
    And click on login button
    Then user should see the error message

  Scenario Outline: invalid login
    Given user is on login page
    When user enter invalid username
      """
      long string, returns docString

      """
    And user enter invalid password as "<password>"
    And click on login button
    Then user should see the error message

    Examples: 
      | userName | password |
      | Admin    | admin123 |
      | Sarmet   | Sarmet   |

  Scenario: valid Login
    Given user is on login page
    When user enter invalid username as below
      | admin   |
      | regular |
    And user enter invalid password
    And click on login button
    Then user should see the error message
