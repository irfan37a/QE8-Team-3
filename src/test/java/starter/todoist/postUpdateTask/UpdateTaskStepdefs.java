package starter.todoist.postUpdateTask;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class UpdateTaskStepdefs {
    @Given("Update a task with valid id {string} but invalid token")
    public void updateATaskWithValidIdButInvalidToken(String arg0) {
    }

    @When("Send request update a task")
    public void sendRequestUpdateATask() {
    }

    @Given("Update a task with valid id {string} with valid json")
    public void updateATaskWithValidIdWithValidJson(String arg0) {
    }

    @Given("Update a label with invalid id {int}")
    public void updateALabelWithInvalidId(int arg0) {
    }
}
