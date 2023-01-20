@GroupProject
Feature: Update sections
  Scenario: Post Update a sections
    Given Post Update a sections with id "113135935"
    When Send request post Update a sections
    Then Should return status code 200