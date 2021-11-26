Feature:

  Background:
    Given user enter the GMIBank website

  @TC_001 @invalidUsername
    Scenario Outline:
    And click human dropdown button right topside
    And click sign in button
    And enter a invalid "<username>" in the username box
    And enter a valid "<password>" in the password box
    And click to sing in button
    Then User is not be able to login with invalid username validating the error message
    Then close the application

    Examples:
      | username | password      |
      | admin    | ^320*E7jJ$7@2 |

  @TC_002 @invalidPassword
    Scenario Outline:
    And click human dropdown button right topside
    And click sign in button
    And enter a valid "<username>" in the username box
    And enter a invalid "<password>" in the password box
    And click to sing in button
    And User is not be able to login with invalid username validating the error message
    Then close the application

    Examples:
      | username    | password    |
      | armand.torp | armand.torp |

