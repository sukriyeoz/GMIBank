@us_005 @orcun
Feature:

  Background:
    Given user enter the GMIBank website
    And click human dropdown button right topside
    And click sign in button

  @smoketest
  @TC_001 @invalidUsername
  Scenario Outline:Login page cannot be accessed with invalid username information
    And enter a invalid "<username>" in the username box
    And enter a valid "<password>" in the password box
    And click to sing in button
    Then User is not be able to login with invalid username validating the error message
    Then close the application

    Examples:
      | username | password      |
      | admin    | ^320*E7jJ$7@2 |

  @smoketest
  @TC_002 @invalidPassword
  Scenario Outline:Login page cannot be accessed with invalid password information
    And enter a valid "<username>" in the username box
    And enter a invalid "<password>" in the password box
    And click to sing in button
    Then User is not be able to login with invalid username validating the error message
    And close the application

    Examples:
      | username    | password    |
      | armand.torp | armand.torp |

  @TC_003 @invalidUsernameAndPassword
  Scenario:Login page cannot be accessed with invalid username and invalid password information
    And enter a invalid username and invalid password
      | username | password |
      | admin    | admin    |
    And click to sing in button
    Then User is not be able to login with invalid username validating the error message
    And close the application

  @TC_004 @resetpassword
  Scenario:User with invalid credentials should be given an option to reset their password
    And enter a invalid username and invalid password
      | username | password |
      | admin    | admin    |
    And click to sing in button
    And click to Did you forget your password button
    And enter email address
      | email       |
      | gmi@gmi.com |
    And Click to reset password
    Then Verify that a new password has been sent to your e-mail to reset the password.
    And close the application

  @TC_005 @registerNewAccount
  Scenario:User should be given the option to navigate to registration page if they did not register yet
    And enter a invalid username and invalid password
      | username | password |
      | admin    | admin    |
    And click to sing in button
    Then The user is unable to log in, and it is verified that she cannot log in.
    And click to register a new account button
    And close the application
