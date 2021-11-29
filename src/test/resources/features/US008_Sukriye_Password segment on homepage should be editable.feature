@US_008
Feature:Password segment on homepage should be editable

  Background:User signs in
    Given  user goes to "https://www.gmibank.com/login" loginpage
    And   user provides valid username
    And   user provides valid password
    And   user clicks sign in button



  @US_008-TC_001
  Scenario:US_008 TC_001 Old password can not be used again
   Given user clicks to account menu
    And user clicks to password button to edit
    And  verifies that old password not confirmed



  @US_008-TC_00-2-3-4-5
  Scenario Outline:US_008 TC_00 new password should have at least 1 "<character>" to change line1 color of chart color
    Given user clicks to account menu
    And user clicks to password button to edit
    Then  enter new seven chars "<password>" and verifies that  should be at least one "<character>" at new password and level chart changes accordingly
    Examples:
      |character|password|
      |lowercase |a333333|
      |uppercase |A333333|
      |special |$333333|
      |digit |9aaaaaa|


  #@US_008-TC_006
 # Scenario:US_008 TC_006 New password should have at least 7 chars
  #  Given user clicks to account menu
   # And user clicks to password button to edit
   # And  verifies there is one bug that new password accepts at least four char


  @US_008-TC_007
  Scenario:US_008 TC_007 New password should be confirmed
    Given user clicks to account menu
    And user clicks to password button to edit
    And  verifies that new valid password must be confirmed

