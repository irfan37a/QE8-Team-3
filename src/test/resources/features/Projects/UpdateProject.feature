Feature: Update Projects Todoist

  @PositiveCase
  Scenario Outline: Post update project valid id
    Given Post update project valid id <id>
    When Send post update project request
    Then Status code is 204 No Content
    Examples:
      | id         |
      | 2306325091 |