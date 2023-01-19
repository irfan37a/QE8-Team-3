Feature: Testing todoist API for Delete a Label endpoint

  @GroupProject
  Scenario Outline: Delete a label with valid id
    Given Delete label with valid "<id>"
    When Send request delete label
    Then API should return status code 204
  Examples:
    | id         |
    | 2164522975 |

  @GroupProject
  Scenario Outline: Delete a label with invalid id
    Given Delete label with invalid <id>
    When Send request delete label
    Then API should return status code 404
    Examples:
      | id |
      | 2  |

  @GroupProject
  Scenario Outline: Delete a label with unauthorized token
    Given Delete label with valid "<id>" with invalid token
    When Send request delete label
    Then API should return status code 401
    Examples:
      | id         |
      | 2164522975 |
