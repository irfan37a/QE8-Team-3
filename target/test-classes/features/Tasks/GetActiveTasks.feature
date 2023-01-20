@GroupProject
Feature: Get active task
  Scenario: Get active task
    Given Get active task
    When Send request get active task
    Then Should return status code 200