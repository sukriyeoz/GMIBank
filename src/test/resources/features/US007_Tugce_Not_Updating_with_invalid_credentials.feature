Feature: US007_Tugce_Not_Updating_with_invalid_credentials

  Background:User sign in
    Given  user goes to "http://www.gmibank.com/login" LoginPage
    And   user provides valid username
    And   user provides valid password
    And   user clicks sign in button

  @US_007-TC_001
  Scenario:US_007-TC_001 Email id cannot contain just digits or chars without "@" sign or "." extension
    Given user clicks to user info
    And   user clicks to email button to edit
    Then  verifies that Email id cannot contain invalid chars.

  @US_007-TC_002
  Scenario:US_007-TC_002 There should not be an option of any other language other than English or Turkish
    Given user clicks to user info
    And   user clicks to language button
    Then  verifies that language button does not have any other option except English or Turkish