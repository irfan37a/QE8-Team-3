@GroupProject
Feature: Create new sections
  Scenario: Post create new sections
    Given Post Create new sections with valid json
    When Send request post create new sections
    Then Should return status code 200
