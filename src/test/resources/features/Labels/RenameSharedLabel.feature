@GroupProject
Feature: Testing Todoist API for Rename Shared Label Endpoint

  Scenario: Rename shared label with valid label
    Given Post rename shared label with valid json
    When Send request post rename shared label
    Then API should return status code 204

  Scenario: Rename shared label with invalid label
    Given Post rename shared label with invalid json
    When Send request post rename shared label
    Then API should return status code 404
    #BUGS

  Scenario: Rename shared label with invalid token
    Given Post rename shared label with valid json with invalid token
    When Send request post rename shared label
    Then API should return status code 401

  Scenario: Rename shared label with empty json
    Given Post rename shared label with empty json
    When Send request post rename shared label
    Then API should return status code 400