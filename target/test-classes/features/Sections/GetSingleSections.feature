@GroupProject
Feature: Get a single sections
  Scenario: Get a single sections
    Given Get a single sections id "7025"
    When Send request get a single sections
    Then Should return status code 200