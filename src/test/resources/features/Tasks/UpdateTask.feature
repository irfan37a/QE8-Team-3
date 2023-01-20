@GroupProject
Feature: Testing Todoist API for Update a Task endpoint

  Scenario: Update a Task with valid id
    Given Update a task with valid json and id "6529718710"
    When Send request post update task
    Then  API should return status code 200
    And Response body id should be "6529718710"

  Scenario: Update a Task with invalid id
    Given Update a task with valid json and invalid id "65297187220"
    When Send request post update task
    Then  API should return status code 404

  Scenario: Update a Task with invalid json
    Given Update a task with invalid json and id "6529718710"
    When Send request post update task
    Then  API should return status code 400

  Scenario: Update a Task with invalid token
    Given Update a task with valid json and id "6529718710" with invalid token
    When Send request post update task
    Then  API should return status code 401

  Scenario: Update a Task with empty json
    Given Update a task with empty json and id "6529718710"
    When Send request post update task
    Then  API should return status code 400