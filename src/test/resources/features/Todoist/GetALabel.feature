Feature: Testing Todoist API for Get a Label endpoint

  @GroupProject
  Scenario Outline: Get a label with valid id
    Given Get a label with valid id "<id>"
    When Send request get a label
    Then API should return status code 200
    And Validate body page same as get a label schema
  Examples:
    |id|
    |2164485732  |

  @GroupProject
  Scenario Outline: Get a label with invalid id
    Given Get a label with invalid id <id>
    When Send request get a label
    Then API should return status code 404
    Examples:
      | id |
      | 2  |

  @GroupProject
  Scenario Outline: Get a label with unauthorized token
    Given Get a label with valid id "<id>" but invalid token
    And Send request get a label
    Then API should return status code 401
    Examples:
      |id|
      |2164485732  |