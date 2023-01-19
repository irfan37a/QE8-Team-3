package starter.todoist.postReopenTask;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class ReopenTaskStepdefs {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Reopen a task with valid {string}")
    public void reopenATaskWithValid(String id) {
        todoistAPI.reopenTask(id);
    }

    @When("Send request reopen a task")
    public void sendRequestReopenATask() {
        SerenityRest.when().post(TodoistAPI.POST_REOPEN_TASK);
    }

    @Given("Reopen a task with invalid {int}")
    public void reopenATaskWithInvalidId(int id) {
        todoistAPI.reopenTask_invalidId(id);
    }

    @Given("Reopen a task with valid {string} with invalid token")
    public void reopenATaskWithValidWithInvalidToken(String id) {
        todoistAPI.reopenTask_invalidToken(id);
    }
}
