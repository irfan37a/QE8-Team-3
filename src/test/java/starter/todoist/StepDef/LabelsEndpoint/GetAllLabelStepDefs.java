package starter.todoist.StepDef.LabelsEndpoint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;

import java.io.File;

public class GetAllLabelStepDefs {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Get all labels with valid token")
    public void getAllLabelsWithValidToken() {
        todoistAPI.getAllLabels();
    }

    @When("Send request get all labels")
    public void sendRequestGetAllLabels() {
        SerenityRest.when().get(TodoistAPI.GET_ALL_LABELS);
    }

    @And("Validate body page same as json schema")
    public void validateBodyPageSameAsJsonSchema() {
        File successJsonSchema = new File(Constant.JSON_SCHEMA+"ValidGetAllLabels_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(successJsonSchema));
    }

    @Given("Get all labels with invalid token")
    public void getAllLabelsWithInvalidToken() {
        todoistAPI.getAllLabels_inv_token();
    }
}
