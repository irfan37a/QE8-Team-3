@UpdateComment
  Feature: Update a comment
    Scenario: Update a comment with valid id
      Given Update a comment with valid json and id "3206497169"
      When Send request post update comment
      Then  Should return status code 200
      And Response body id should be "3206497169"
      And Validate json schema update a comment

    Scenario: Update a comment with invalid id
      Given Update a comment with invalid id "134^wr&we"
      When Send request post update comment
      Then Should return status code 404

    Scenario: Update a comment without authentication
      Given Update a comment without authentication
      When Send request post update comment
      Then Should return status code 401

    Scenario: Update a comment with invalid json
      Given Update a comment with invalid json
      When Send request post update comment
      Then Should return status code 400

    Scenario: Update a comment with empty json key
      Given Update a comment with valid id and empty json key
      When Send request post update comment
      Then Should return status code 400

    Scenario: Update a comment with invalid path
      Given Update a comment with valid id
      When Send request post update comment with invalid path
      Then Should return status code 404