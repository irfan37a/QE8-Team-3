package starter.todoist.StepDef.TaskEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class DeleteTaskStepDef {
    @Steps
    TodoistAPI todoistAPI;
    @Given("Delete tasks with valid {string}")
    public void deleteTasksWithValid(String id) {
        todoistAPI.deleteTask(id);
    }

    @When("Send request delete tasks")
    public void sendRequestDeleteTasks() {
        SerenityRest.when().delete(TodoistAPI.DELETE_TASK);
    }
}
