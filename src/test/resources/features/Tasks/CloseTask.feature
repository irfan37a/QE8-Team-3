@CloseTaskg
  Feature: Close a task
    Scenario: Close a task with valid id
      Given Close a task with valid id "6529449890"
      When Send request post close task
      Then Should return status code 204

    Scenario: Close a task with invalid id
      Given Close a task with invalid id "123hr&^"
      When Send request post close task
      Then Should return status code 400

    Scenario: Close a task without authentication
      Given Close task without authentication
      When Send request post close task
      Then Should return status code 401

    Scenario: Close a task with invalid path
      Given Close a task with valid id
      When Send request post close task with invalid path
      Then Should return status code 404