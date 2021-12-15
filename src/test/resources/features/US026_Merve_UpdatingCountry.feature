@CountryUpdate
  Feature: System should allow to update countries using api end point "https://www.gmibank.com/api/tp-countries"

 //   Background:
     // Given user creates token via api endpoint "https://gmibank-qa-environment.com/api/authenticate"

      Scenario: User can update a country
        When user updates a country by using api end point "https://www.gmibank.com/api/tp-countries"
        Then validates if the country has been updated


    @UpdateCountry
    Scenario Outline: update a country
      Given user sets the response using api end point "https://www.gmibank.com/api/tp-countries" and updates country using "<idJson>" and "<nameJson>"



      Examples: update country
        |idJson|nameJson|
        |19246|Georgia|