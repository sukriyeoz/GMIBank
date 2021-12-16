@Demox
Feature: Register new applying

  # The customer registers on the site.
  # Admin should accept the customer registration.
  # Employee creates at least two Account for customer.
  # Employee adds these accounts to customer.
  # Customer logins to system.
  # Customer makes money Transfer between accounts.


  @registerNewCustomerIU
  Scenario: Register new user2
    Given _user is on the registration page
    And _user enters ssn number as "newcustomer_ssn"
    Then _user enters firstname as "newcustomer_firstname"
    Then _user enters lastname  as "newcustomer_lastname"
    When _user provides address "newcustomer_address"
    Then _user provides phoneNumber as "newcustomer_phone"
    And _user provides a username "newcustomer_username"
    Then _user provides email id as "newcustomer_email"
    When _user enters the password as "newcustomer_fpassword"
    And _user confirms the new password "newcustomer_spassword"
    Then _user clicks on register button and sees the success message as "newcustomer_successfulmessage"


  @adminActivation
  Scenario: Account Activation
    Given admin goes to login page
    And admin enter "admin_usernamee" and "admin_passwordd"
    And admin clicks sig in button_
    And admin clicks on the administration button
    And admin clicks on the user management button
    Then admin finds customer "newcustomer_username" and activates user
    And  admin signs out


  @employeeToCreateAccount
  Scenario Outline: Employee logs in and create two new accounts
    Given employee login page with username "employee_usernamee" and password "employee_passwordd"
    And click My Operations and clicks manage accounts
    And click to create a new account
    And enter a description "<description>"
    And enter a balance "<balance>"
    And choose an account type "<type>"
    And chose an account status "<account_status>"
    Then click save button
    And employee signs out

    Examples:
      | description         | balance | type     | account_status |
      | oooChecking Account | 10000   | CHECKING | ACTIVE         |
      | oooSaving Account   | 10000   | SAVING   | ACTIVE         |


  @customerCreation
  Scenario: Employee log in page and create
    Given employee login page with username "employee_usernamee" and password "employee_passwordd"
    And click My Operations and clicks manage customers
    And click to create a new customer
    And employee types the SSN as "newcustomer_ssn"
    And click on the search button
    Then enter the middle name initial as "newcustomer_middlename"
    And enter phone number as "newcustomer_phone"
    And enter zip code as "newcustomer_zipcode"
    And enter city as "newcustomer_city"
    And choose a country as "newcustomer_country"
    And enter a State as "newcustomer_state"
    And choose two accounts
    Then click on the Save button
    And employee signs out


  Scenario: New customer log in account for transactions
    Given customer goes to login page
    And customer provides username "newcustomer_username" and password "newcustomer_fpassword"
    And click on the sign in
    And click on My Operations button
    And click on Transfer Monet button
    When customer selects current account to withdraw money from
    And customer selects other account to send monet to
    And customer provides the balance "newcustomer_transferBalance"
    And customer types the description
    Then customer click on make transfer button
    And customer sees the successful message as "newcustomer_transfersuccessfulmessage"
    And close the browser

