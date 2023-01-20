@GroupProject
Feature: Get all sections
  Scenario: Get all section valid project id
    Given Get all section with valid project id "2203306141"
    When Send request get all sections
    Then Should return status code 200
