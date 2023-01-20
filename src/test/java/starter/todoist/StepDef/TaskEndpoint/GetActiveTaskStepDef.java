package starter.todoist.StepDef.TaskEndpoint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;
import starter.todoist.Utils.TodoistResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetActiveTaskStepDef {
    @Steps
    TodoistAPI toDoIstApi;

    @Given("Get an active task with valid id {string}")
    public void getAnActiveTaskWithValidId(String id) {
        toDoIstApi.getActiveTask(id);
    }

    @When("Send request get an active task")
    public void sendRequestGetAnActiveTask() {
        SerenityRest.when()
                .get(toDoIstApi.GET_ACTIVE_TASK);
    }

    @And("Return body should be id = {string}")
    public void returnBodyShouldBeId(String id) {
        SerenityRest.then().body(TodoistResponse.ID,equalTo(id));
    }

    @And("Validate json schema get an active task")
    public void validateJsonSchemaGetAnActiveTask() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"GetActiveTaskSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get an active task with invalid id {string}")
    public void getAnActiveTaskWithInvalidId(String id) {
        toDoIstApi.getActiveTask(id);
    }

    @Given("Get an active task without authentication")
    public void getAnActiveTaskWithoutAuthentication() {
        String id = "6529449890";
        toDoIstApi.noAuthGetActiveTask(id);
    }

    @Given("Get an active task with valid id")
    public void getAnActiveTaskWithValidId() {
        String id = "6529449890";
        toDoIstApi.getActiveTask(id);
    }

    @When("Send request get an active task with invalid path")
    public void sendRequestGetAnActiveTaskWithInvalidPath() {
        SerenityRest.when()
                .get(toDoIstApi.INVALID_GET_ACTIVE_TASK);
    }
}
