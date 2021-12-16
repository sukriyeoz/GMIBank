@US001
Feature: US001 - RegistrationPage
  (System should allow any user to register with valid credentials validating the success message)

  Background:
    Given User enter to webPage
    And User clicks on human icon
    And User clicks on register Button
<<<<<<< HEAD
@smoketest
=======

  @smoketest
>>>>>>> master
  Scenario: TC001 - There should be a valid SSN respecting the "-" where necessary,
  it should be 9 digits long
    And User Enter the "ssn" number
    Then ssn number should be valid

  Scenario: TC002 - There should be a valid name that contains chars and cannot be blank
    And  User Enter the "firstname"
    Then Firstname should be valid

  Scenario: TC003 - There should be a valid lastname that contains chars and it is a required field
    And User Enter "lastname"
    Then Lastname should be valid

  Scenario: TC004 - You can provide chars and digits to describe a valid address along with zip code
    And User Enter the address
    Then address should be valid

  Scenario: TC005 - User should provide 10 digit-long mobilephone number as a required field respecting the "-"
    And User Enter the phonenumber
    Then PhoneNumber should be valid

  Scenario: TC006 - User cannot use just digits but can use any chars and digits along with them and of any length
    And User Enter the username
    Then username should be valid

  Scenario: TC007 - You should provide a valid email format that contains "@"sign and "." extensions
    And User Enter the email
    Then email should be valid

  Scenario: TC008 - User should use valid password
    And User Enter the password
    Then Password should be valid


  Scenario: TC009 - Use java faker for valid registration
    And user enters fields with valid data
    Then user clicks on register button and sees the success message as_ "Registration saved!".
    Then close the page