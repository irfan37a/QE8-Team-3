@GroupProject
Feature: Testing Todoist API for Update a Label endpoint

  Scenario: Update a label with valid id
    Given Update a label with valid id "2164485800" and valid json
    When Send request update a label
    Then  API should return status code 200
    And Response label body id should be "2164485800"

  Scenario: Update a label with invalid id
    Given Update a label with invalid id 2 but valid json
    When Send request update a label
    Then  API should return status code 404

  Scenario: Update a label with unauthorized token
    Given Update a label with valid id "2164485800" but invalid token
    When Send request update a label
    Then API should return status code 401

  Scenario: Update a label with invalid json
    Given Update a label with valid id "2164485800" with invalid json
    When Send request update a label
    Then API should return status code 400

  Scenario: Update a label with empty json
    Given Update a label with valid id "2164485800" with empty json
    When Send request update a label
    Then API should return status code 400