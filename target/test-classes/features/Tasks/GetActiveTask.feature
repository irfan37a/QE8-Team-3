@GroupProject
  Feature: Get an active task
    Scenario: Get an active task with valid id
      Given Get an active task with valid id "6529449890"
      When Send request get an active task
      Then Should return status code 200
      And Return body should be id = "6529449890"
      And Validate json schema get an active task

    Scenario: Get an active task with invalid id
      Given Get an active task with invalid id "erqr134%_)"
      When Send request get an active task
      Then Should return status code 404

    Scenario: Get an active task without authentication
      Given Get an active task without authentication
      When Send request get an active task
      Then Should return status code 401

     Scenario: Get an active task with invalid path
       Given Get an active task with valid id
       When Send request get an active task with invalid path
       Then Should return status code 404