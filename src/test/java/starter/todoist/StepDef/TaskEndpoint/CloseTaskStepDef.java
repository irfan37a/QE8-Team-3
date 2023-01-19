package starter.todoist.StepDef.TaskEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class CloseTaskStepDef {
    @Steps
    TodoistAPI toDoIstApi;

    @Given("Close a task with valid id {string}")
    public void closeATaskWithValidId(String id) {
        toDoIstApi.closeTask(id);
    }

    @When("Send request post close task")
    public void sendRequestPostCloseTask() {
        SerenityRest.when()
                .post(toDoIstApi.CLOSE_TASK);
    }

    @Given("Close a task with invalid id {string}")
    public void closeATaskWithInvalidId(String id) {
        toDoIstApi.closeTask(id);
    }

    @Given("Close task without authentication")
    public void closeTaskWithoutAuthentication() {
        String id = "6529449890";
        toDoIstApi.noAuthCloseTask(id);
    }

    @Given("Close a task with valid id")
    public void closeATaskWithValidId() {
        String id = "6529449890";
        toDoIstApi.closeTask(id);
    }

    @When("Send request post close task with invalid path")
    public void sendRequestPostCloseTaskWithInvalidPath() {
        SerenityRest.when()
                .post(toDoIstApi.INVALID_CLOSE_TASK);
    }
}
