@US025_CreateCountry
  Feature: System should allow to create new countries using api end point
   if not created already

  Scenario: User can Just create each country one by one
    Given User use "https://www.gmibank.com/api/tp-countries" endpoint to create new country
     And read all country from endpoint "https://www.gmibank.com/api/tp-countries"
     Then verify the new country

