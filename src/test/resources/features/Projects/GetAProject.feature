Feature: Get Projects Todoist

  @PositiveCase
  Scenario Outline: Get project valid id
    Given Get project valid id <id>
    When Send get project request
    Then Status code is 200 OK
    And Validate get project json schema validator
    Examples:
      | id         |
      | 2306325091 |
