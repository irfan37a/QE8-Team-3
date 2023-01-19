Feature: Testing Todoist API for Create New User Endpoint

  @GroupProject
  Scenario: Create a new label with valid json request
    Given Post create label with valid json
    When Send request post create label
    Then API should return status code 200
    And Validate json schema create new label

  @GroupProject
  Scenario: Create a new label with invalid json
    Given Post create label with invalid json
    When Send request post create label
    Then API should return status code 400

  @GroupProject
  Scenario: Create a new label with empty name
    Given Post create label with empty name
    When Send request post create label
    Then API should return status code 400

  @GroupProject
  Scenario: Create a new label with invalid token
    Given Post create label with valid json invalid token
    When Send request post create label
    Then API should return status code 401

