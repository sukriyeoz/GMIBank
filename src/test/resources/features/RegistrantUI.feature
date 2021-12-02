Feature: Register new applicants_

  Scenario Outline: Register new users for GMI Bank
    Given user is on the registration page
    And user enters ssn number as "<ssn>"
    Then user enters firstname as "<firstname>"
    Then user enters lastname  as "<lastname>"
    When user provides address "<address>"
    Then user provides phoneNumber as "<phonenumber>"
    And user provides a username "<username>"
    Then user provides email id as "<email>"
    When user enters the password as "<firstpassword>"
    And user confirms the new password "<secondpassword>"
    Then user clicks on register button and sees the success message as "<message>"
    Then user reads all registrant data

    Examples:
      | ssn         | firstname  | lastname   | address          | phonenumber  | username   | email                | firstpassword | secondpassword | message             |
      | 111-11-1125 | xcustomer2 | xcustomer2 | 25 xcustomer2 st | 111-111-1125 | xcustomer2 | xcustomer2@gmail.com | Gmi12345.     | Gmi12345.      | Registration saved! |
      |             |            |            |                  |              |            |                      |               |                |                     |



