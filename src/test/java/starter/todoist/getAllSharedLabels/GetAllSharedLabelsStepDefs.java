package starter.todoist.getAllSharedLabels;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;

import java.io.File;

public class GetAllSharedLabelsStepDefs {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Get all shared labels with valid token")
    public void getAllSharedWithValidToken() {
        todoistAPI.getAllSharedLabels();
    }

    @When("Send request get all shared labels")
    public void sendRequestGetAllSharedLabels() {
        SerenityRest.when().get(TodoistAPI.GET_ALL_SHARED_LABELS);
    }

    @And("Validate body page same as json schema get all shared labels")
    public void validateBodyPageSameAsJsonSchemaGetAllSharedLabels() {
        File successJsonSchema_Shared = new File(Constant.JSON_SCHEMA+"/ValidGetAllSharedLabels_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(successJsonSchema_Shared));
    }

    @Given("Get all shared labels with invalid token")
    public void getAllSharedWithInvalidToken() {
        todoistAPI.getAllSharedLabels_inv_token();
    }
}
