@GetComments
Feature: Get a comment
  Scenario: Get a comment with valid parameter
    Given Get a comment with valid parameter id "3206497169"
    When Send request get a comment
    Then Should return status code 200
    And Response body page should be id "3206497169"
    And Validate json schema get a comment

  Scenario: Get a comment with invalid parameter
    Given Get a comment with invalid parameter id "sadajs*&^12"
    When Send request get a comment
    Then Should return status code 404

  Scenario: Get a comment without parameter
    Given Get a comment without parameter id
    When Send request get a comment without parameter id
    Then Should return status code 400

  Scenario: Get a comment without authentication
    Given Get a comments without authentication
    When Send request get a comment
    Then Should return status code 401

  Scenario: Get a comments with invalid path
    Given Get a comment with invalid path
    When Send request get a comments with invalid path
    Then Should return status code 404