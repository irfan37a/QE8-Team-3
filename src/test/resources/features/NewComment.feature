@CreateNewComment
Feature: Create new comment
  Scenario: Post create new comment with valid json
    Given Post comment with valid json
    When Send request post new comment
    Then Should return status code 200
    And Response body project_id should be "2306143459"
    And Validate json schema create new comment

  Scenario: Post create new comment with invalid path
    Given Post comment with invalid path
    When Send request post new comment invalid path
    Then Should return status code 404

  Scenario: Post create new comment without authentication
    Given Post comment without authentication
    When Send request post new comment
    Then  Should return status code 401

  Scenario: Post create new comment with empty json key
    Given Post comment with empty json key
    When Send request post new comment
    Then Should return status code 400

  Scenario: Post create new comment with invalid json
    Given Post comment with invalid json
    When Send request post new comment
    Then Should return status code 400