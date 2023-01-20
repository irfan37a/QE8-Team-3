@GroupProject
Feature: Delete tasks
  Scenario: Delete tasks
    Given Delete tasks with valid "2995104339"
    When Send request delete tasks
    Then API should return status code 204