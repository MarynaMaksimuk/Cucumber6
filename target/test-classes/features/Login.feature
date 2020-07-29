Feature: Login

  @smoke
  Scenario: Valid admin login
    When user entered valid admin username and valid password
    And user click on login button
    Then admin user successfully logged in

  @smoke
  Scenario: valid ess login
    When user entered valid ess username and valid password
    And user click on login button
    Then ess user successfully logged in

  @regression
  Scenario: Login with valid username and invalid password
    When user entered valid username and invalid password
    And user click on login button
    Then user sees Invalid Credentials message
