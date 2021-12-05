@verify
Feature: US007_Tugce_Not_Updating_with_invalid_credentials

  Background:
    Given  user goes to bank main page
    Given user clicks human button
    Given user clickss sign_in button
    And   user providess valid username
    And   user providess valid password
    And   user clickss sign in button
    And   clicks on dropdown button right topside
    Given user clicks to userInfoo


  @US_007-TC_001_
  Scenario:US_007-TC_001 Email id cannot contain just digits or chars without "@" sign or "." extension
    And Clear the email boxx
    Given enter as a new email
    And Clear the email boxx
    Given enter as a new second email
    Then user should see the error message
    Then user closes the browser
  @smoketest
  @US_007-TC_002_
  Scenario:US_007-TC_002 There should not be an option of any other language other than English or Turkish
    Then user clicks to language button
    Then  verifies that language button does not have any other option except English or Turkish
    Then user closes the browser