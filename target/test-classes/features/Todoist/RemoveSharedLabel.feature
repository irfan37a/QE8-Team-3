Feature: Testing todoist API for Remove Shared Label endpoint

  @GroupProject
  Scenario: Remove Shared Label with valid label
    Given Remove Shared Label with valid json
    When Send request Remove Shared Label
    Then API should return status code 204


  @GroupProject
  Scenario: Remove Shared Label with invalid label
    Given Delete label with invalid json
    When Send request Remove Shared Label
    Then API should return status code 404
    #BUGS


  @GroupProject
  Scenario: Remove Shared Label with unauthorized token
    Given Delete label with valid json with invalid token
    When Send request Remove Shared Label
    Then API should return status code 401
