@US004
Feature: US004 - Login page should accessible with valid credentials

  Scenario Outline: TC001 - There should be a valid username and password validating the success message to login
    Given user go to GMI webpage
    And user click on the account menu
    And user click on sign in
    And user enter a valid "<username>" to usernameTextbox
    And user enter a valid "<password>" to passwordTextbox
    And user click on "Sign in" button
    Then user verify success message for login with valid credentials
    And user closes web page

    Examples:
      | username   | password  |
      | xmanager   | Gmi12345. |
      | xadmin     | Gmi12345. |
      | xemployee  | Gmi12345. |
      | xuser      | Gmi12345. |
      | xcustomer  | Gmi12345. |
      | xcustomer2 | Gmi12345. |


  @smoketest
  Scenario Outline: TC002 - There should be an option to cancel login
    Given user go to GMI webpage
    And user click on the account menu
    And user click on sign in
    And user enter a valid "<username>" to usernameTextbox
    And user enter a valid "<password>" to passwordTextbox
    And user click on Cancel button
    Then user verifies to cancel login
    And user closes web page

    Examples:
      | username | password   |
      | xuser    | Gmi12345.. |