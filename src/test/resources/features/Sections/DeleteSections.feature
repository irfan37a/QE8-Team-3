@GroupProject
Feature: Delete sections
  Scenario: Delete sections valid id
    Given Delete sections with valid "7025"
    When Send request delete sections
    Then API should return status code 204