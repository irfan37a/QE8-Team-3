@GroupProject
Feature: Testing Todoist API for Get All Label endpoint

  Scenario: Get all labels with valid token
    Given Get all labels with valid token
    When Send request get all labels
    Then API should return status code 200
    And Validate body page same as json schema


  Scenario: Get all labels with unauthorized token
    Given Get all labels with invalid token
    And Send request get all labels
    Then API should return status code 401