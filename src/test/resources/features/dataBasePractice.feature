Feature: Syntax HRMS database testing

  Background: 
    Given user creat connection with SyntaxHRMS database
    And user creates a statement
    

  Scenario: JobTitle validation for SyntaxHRMS database
    When user retrives all job titles from SyntaxHRMS database
    Then user validates results for job titles
      | job_title                         |
      | Accountant                        |
      | Application Developer             |
      | Automation engineer               |
      | Bakery Chef                       |
      | CEO                               |
      | Chief Financial Officer           |
      | Cloud Architect                   |
      | Cloud Consultant                  |
      | Cloud Product and Project Manager |
      | Controller                        |
      | Data Quality Manager              |
      | Database Administrator            |
      | Developer                         |
      | dsd                               |
      | Film Director                     |
      | Freelancer                        |
      | Graphic Designer                  |
      | IT Analyst                        |
      | IT Support Manager                |
      | Jr Production Manager             |
      | Jr Sales Manager                  |
      | Machine technician                |
      | Network Administrator             |
      | Pilot                             |
      | Production Manager                |
      | QA Tester                         |
      | Quality Assurance Tester          |
      | Sales&Marketing Manager           |
      | ttttt                             |
    And user closes all connections
