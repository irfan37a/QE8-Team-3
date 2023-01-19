Feature: Testing Todoist API for Update a Label endpoint

  @GroupProject
  Scenario: Update a label with valid id
    Given Update a label with valid id "2164485800" with valid json
   # When Post update a label "2164485800" same as json
    And Send request update a label
    Then API should return status code 200
    And Validate body page same as update a label schema

  @GroupProject
  Scenario: Update a label with invalid id
    Given Update a label with invalid id 2
  #  When Post update a label same as json
    And Send request update a label
    Then API should return status code 404

  Scenario: Update a label with unauthorized token
    Given Update a label with valid id "2164485800" but invalid token
 #   When Post update a label same as json
    And Send request update a label
    Then API should return status code 401

  Scenario: Update a label with invalid json
    Given Update a label with valid id "2164485800" with valid json
   # When Post update a label same as invalid json
    And Send request update a label
    Then API should return status code 400


  Scenario: Update a label with empty json
    Given Update a label with valid id "2164485800" with valid json
  #  When Post update a label same as empty json
    And Send request update a label
    Then API should return status code 400