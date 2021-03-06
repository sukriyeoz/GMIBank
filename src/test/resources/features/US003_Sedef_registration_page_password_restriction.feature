@password_strenght
Feature: US003_registration_password

  @password_lowercase
  Scenario: TC001_lowercase_password
    Given user is on the application page
    Given user enters all required fields
      | getSSN    | fName | lName  | address1               | phoneNumber | userName    | emailAddress     |
      | 326547896 | Alexa | Amazon | 1861 Amazon Dr Florida | 6785214552  | AlexaAmazon | alexa@amazon.com |
    Given user enters a password which not include lowercase char
    And user enter the same password again
  #  And user clicks on the register_botton
    Then close the application

  @password_uppercase
  Scenario: TC002_uppercase_password
    Given user is on the application page
    Given user enters all required fields
      | getSSN    | fName | lName  | address1               | phoneNumber | userName    | emailAddress     |
      | 326547896 | Alexa | Amazon | 1861 Amazon Dr Florida | 6785214552  | AlexaAmazon | alexa@amazon.com |
    Given user enters a password which not include uppercase char
    And user enter the same upperpassword again
   #   And user clicks on the register_botton
    Then close the application

  @password_number
  Scenario: TC003_include_number_password
    Given user is on the application page
    Given user enters all required fields
      | getSSN    | fName | lName  | address1               | phoneNumber | userName    | emailAddress     |
      | 326547896 | Alexa | Amazon | 1861 Amazon Dr Florida | 6785214552  | AlexaAmazon | alexa@amazon.com |
    Given user enters a password which not include number
    And user enter the same numberpassword again
    #    And user clicks on the register_botton
    Then close the application

  @password_special_char
  Scenario: TC004_special_char_password
    Given user is on the application page
    Given user enters all required fields
      | getSSN    | fName | lName  | address1               | phoneNumber | userName    | emailAddress     |
      | 326547896 | Alexa | Amazon | 1861 Amazon Dr Florida | 6785214552  | AlexaAmazon | alexa@amazon.com |
    Given user enters a password which not include special_char
    And user enter the same special_char_password again
    # And user clicks on the register_botton
    Then close the application

  @password_seven_char
  Scenario: TC005_seven_char_password
    Given user is on the application page
    Given user enters all required fields
      | getSSN    | fName | lName  | address1               | phoneNumber | userName    | emailAddress     |
      | 326547896 | Alexa | Amazon | 1861 Amazon Dr Florida | 6785214552  | AlexaAmazon | alexa@amazon.com |
    Given user enters a password which is less than seven char
    And user enter the same seven_char_password again
    # And user clicks on the register_botton
    Then close the application

  @smoketest
  @password_strong_chars
  Scenario: TC006_strong_password
    Given user is on the application page
    Given user enters all required fields
      | getSSN    | fName | lName  | address1               | phoneNumber | userName    | emailAddress     |
      | 326547896 | Alexa | Amazon | 1861 Amazon Dr Florida | 6785214552  | AlexaAmazon | alexa@amazon.com |
    Given user enters a password which is include all required field
    And user enter the same strong_password again
   # And user clicks on the register_botton
    Then close the application




