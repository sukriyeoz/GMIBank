@US024_CreateState
  Feature: System should allow to create new states using api end point if not created already


   Scenario: User can Just create each state one by one
      Given user use endpoint "https://www.gmibank.com/api/tp-states" and create new states
      Then read all states from end point "https://www.gmibank.com/api/tp-states"
      And verify new states




