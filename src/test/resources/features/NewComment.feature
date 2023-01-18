@CreateNewComment
Feature: Create new comment
  Scenario: Post create new user with valid json
    Given Post comment with valid json
    When Send request post new comment
    Then Should return status code 200
    And Response body project_id should be "2306143459"
    And Validate json schema create new comment