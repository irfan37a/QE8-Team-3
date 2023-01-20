@GroupProject
Feature: Testing todoist API for Delete a Label endpoint

  Scenario Outline: Delete a label with valid id
    Given Delete label with valid "<id>"
    When Send request delete label
    Then API should return status code 204
  Examples:
    | id         |
    | 2164522975 |

  Scenario Outline: Delete a label with invalid id
    Given Delete label with invalid <id>
    When Send request delete label
    Then API should return status code 404
    Examples:
      | id |
      | 2  |
  #BUGS

  Scenario Outline: Delete a label with unauthorized token
    Given Delete label with valid "<id>" with invalid token
    When Send request delete label
    Then API should return status code 401
    Examples:
      | id         |
      | 2164522975 |
