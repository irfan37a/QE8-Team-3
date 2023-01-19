Feature: Testing todoist API for Reopen a Task endpoint

  @GroupProject
  Scenario Outline: Reopen a task with valid id
    Given Reopen a task with valid "<id>"
    When Send request reopen a task
    Then API should return status code 204
    Examples:
      | id |
      | 6529718710   |

  @GroupProject
  Scenario Outline: Reopen a task with invalid id
    Given Reopen a task with invalid <id>
    When Send request reopen a task
    Then API should return status code 404
    Examples:
      | id |
      | 2  |

  @GroupProject
  Scenario Outline: Reopen a task with unauthorized token
    Given Reopen a task with valid "<id>" with invalid token
    When Send request reopen a task
    Then API should return status code 401
    Examples:
      | id         |
      | 2164522975 |
