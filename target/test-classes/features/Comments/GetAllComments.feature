@GroupProject
Feature: Get all comments
  Scenario: Get all comments with valid project id
    Given Get all comments with valid project id "2306143459"
    When Send request get all comments
    Then Should return status code 200
    And Response body page should be project_id "2306143459"
    And Validate json schema get all comments

  Scenario: Get all comments with invalid project id
    Given Get all comments with invalid project id "%42293akswq"
    When Send request get all comments
    Then Should return status code 400

   Scenario: Get all comments without project id
     Given Get all comments without project id
     When Send request get all comments without project id
     Then Should return status code 400

   Scenario: Get all comments without authentication
     Given Get all comments without authentication
     When Send request get all comments
     Then Should return status code 401

   Scenario: Get all comments with invalid path
     Given Get all comments with invalid path
     When Send request get all comments with invalid path
     Then Should return status code 404