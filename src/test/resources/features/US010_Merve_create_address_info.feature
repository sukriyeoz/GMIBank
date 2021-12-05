@create_address_info
Feature:  create_address_info

  Background: Navigating_to_the_page
    Given user enter the GMIBank Webpage
    And click human button right topside
    And user click sign in button
    And sign in with employee credentials
    And click the Manage Customers option from the My Operations dropdown
    And click create a new customer button
    And user enter all required fields

  @smoketest
  @Address
  Scenario: TC01_Address_cannot_be_blank
    And the address box should be left blank
    Then verify "this field is required" text message at the bottom of the address box
    Then closes the application


  @City
  Scenario: TC02_City_cannot_be_blank
    And city box should be left blank
    Then verify "this field is required" text message at the bottom of the city box
    Then closes the application

  @Country
  Scenario: TC03_Country_cannot_be_blank
    And country box should be left blank
    Then verify "this field is required" text message at the bottom of the country box
    Then closes the application

  @State
  Scenario: TC04_State_cannot_be_blank
    And state box should be left blank
    Then verify "this field is required" text message at the bottom of the state box
    Then closes the application