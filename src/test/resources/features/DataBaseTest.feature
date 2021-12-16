@DB9Testing
Feature: Databa testing
  Background:
    Given user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
  @db9test
  Scenario Outline: database testing
    Given user sends their query to db and gets related data "<query>" and "<columnName>"
    And user sets DB data into correspondent files
    Then user validates db data using records
    Examples: test data
      |query|columnName|
      |Select * from tp_customer|ssn|


