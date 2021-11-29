@US002
Feature: US002 - System should not allow anyone to register with invalid credentials
  seeing the message "If you want to sign in, you can try the default
  accounts:- Administrator (login="admin" and password="admin")
  - User (login="user" and password="user").

  Background:
    Given user enters the GMIBank web page
    And User clicks on man icon.
    And User clicks on the register button


  Scenario: TC001 - Any field on the registration page should not be left blank
    When user clicks on register button without filling mandatory areas
    Then user verify error messages for all fields on the registration page


  Scenario Outline: TC002 - SSN number cannot be of any chars nor spec chars except "-",
  and SSN cannot start with 999 and 000
    When user types  "<SSN>" number to SSN box
    Then user verify that invalid format of SSN number leads to error message

    Examples:
      | SSN         |
      | 42??@#38+78 |
      | 55#!77%^23  |
      | 1!1#12$45!  |
      | 999-11-1111 |
      | 000-00-0000 |
      | 000-15-5487 |


  Scenario Outline:  TC003 - Mobilephone number cannot be of any chars nor spec chars except "-"
    When user enter "<phonenumber>" number to phonenumber box
    Then user verifies that invalid format of phone number to error message

    Examples:
      | phonenumber |
      | 2!3+48*7*94 |
      | 518/77/7*-1 |
      | 3!3*69$#^^8 |


  Scenario Outline:TC004 - Email id cannot be created without "@" sign and "." extensions
    When user enter "<email>" data to email box
    Then user verifies that invalid format of email leads to error message

    Examples:
      | email            |
      | herewegomail.com |
      | herewego@mailcom |
      | herwegomailcom   |