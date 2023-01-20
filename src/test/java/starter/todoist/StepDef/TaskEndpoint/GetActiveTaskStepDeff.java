package starter.todoist.StepDef.TaskEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class GetActiveTaskStepDeff {

    @Steps
    TodoistAPI toDoIstApi;

    @Given("Get active task")
    public void getActiveTask() {
        toDoIstApi.getActiveTask2();
    }

    @When("Send request get active task")
    public void sendRequestGetActiveTask() {
        SerenityRest.when()
                .get(toDoIstApi.GET_ACTIVE_TASK2);
    }
}
