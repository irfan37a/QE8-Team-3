@GroupProject
  Feature: Delete a comment
    Scenario: Delete a comment with valid id
      Given Delete a comment with valid id "3206471987"
      When Send request delete a comment
      Then Should return status code 204

    Scenario: Delete a comment with invalid id
      Given Delete a comment with invalid id "qwe@!#123"
      When Send request delete a comment
      Then Should return status code 404

    Scenario: Delete a comment without authentication
      Given Delete a comment without authentication
      When Send request delete a comment
      Then Should return status code 401

    Scenario: Delete a comment with unregistered id
      Given Deleta a comment with unregistered id "0000000000"
      When Send request delete a comment
      Then Should return status code 404

    Scenario: Delete a comment with invalid path
      Given Delete a comment with valid id
      When Send request delete a comment with invalid path
      Then Should return status code 404