Feature: US003_registration_password

  @password_lowercase
  Scenario: TC001_lowercase_password
    Given user is on the application page
    Given user enters all required fields
     |getSSN |fName|lName|address1|phoneNumber |userName   |emailAddress|
    |326547896  |Alexa|Amazon       |1861 Amazon Dr Florida  |6785214552|AlexaAmazon|alexa@amazon.com         |
    Given user enters a password which not include lowercase char
    And user enter the same password again
    And user clicks on the register_botton
    Then user verifies the success_message




