@US002_Emrah
Feature:

  Background:
    Given user enter the GMIBank Webpage
    And click human button right topside
    And click Register in button

  @TC_001_SNN_Testing
  Scenario:
    And user enters fields with invalid data
    And user clicks on the register button
#    Then verify success message
#    Then close the page