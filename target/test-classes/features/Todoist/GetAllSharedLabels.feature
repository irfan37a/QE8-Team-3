Feature: Testing Todoist API for Get All Shared Labels endpoint

  @GroupProject
  Scenario: Get all shared labels with valid token
    Given Get all shared "labels" with valid token
    When Send request get all shared labels
    Then API should return status code 200
    And Validate body page same as json schema get all shared labels

  @GroupProject
  Scenario: Get all shared labels with unauthorized token
    Given Get all shared "labels" with invalid token
    And Send request get all shared labels
    Then API should return status code 401