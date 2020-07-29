Feature: AddEmployee

  Background: 
    When user entered valid admin username and valid password
    And user click on login button
    Then user navigates to Add Employee Page
	@report
  Scenario: Add employee with first and last name
    When user enters employee "John" "Smith"
    And user clicks save button
    Then employee successfully added

  Scenario: Add employee without employee ID
    When user enters employee "John" "Smith"
    And user delets id number
    And user clicks save button
    Then employee successfully added empl without ID

  
  Scenario: AddEmployee and create Login Credentials
    When user enters employee "John" "Smith"
    And user clicks on create login checkbox
    And user enters  login credentials
    And user clicks save button
    Then employee is added successfully

  @inProgress
  Scenario Outline: Adding multiple employees
    When user enters employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user clicks save button
    Then "<FirstName>", "<MiddleName>" and "<LastName>" successfully added

    Examples: 
      | FirstName | MiddleName | LastName |
      | John      | J          | Cohen    |
      | Mary      | T          | Smith    |
      | Samuel    | J          | Adams    |

  #adding multiple employees using cucumber DataTable
  
  Scenario: adding multiple employees
  When user enters employee details and click on save then employee is added
    
    |FirstName|MiddleName|LastName|
    | Samuel    | H          | Adams    |
    | Mike      | O          | Niel     |



  @excel
  Scenario: Adding multiple employees from Excel
    When user enters data from Sheet1 excel then employee is added
    
   
