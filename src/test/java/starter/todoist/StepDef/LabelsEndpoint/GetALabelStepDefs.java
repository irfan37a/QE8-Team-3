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

public class GetALabelStepDefs {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Get a label with valid id {string}")
    public void getALabelWithValidId(String id) {
        todoistAPI.getALabels(id);
    }

    @When("Send request get a label")
    public void sendRequestGetALabel() {
        SerenityRest.when().get(TodoistAPI.GET_A_LABEL);
    }

    @And("Validate body page same as get a label schema")
    public void validateBodyPageSameAsGetALabelSchema() {
        File successJsonSchema = new File(Constant.JSON_SCHEMA+"ValidALabel_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(successJsonSchema));
    }

    @Given("Get a label with valid id {string} but invalid token")
    public void getALabelWithValidIdButInvalidToken(String id) {
        todoistAPI.getALabels_invalid_token(id);
    }

    @Given("Get a label with invalid id {int}")
    public void getALabelWithInvalidId(int id) {
        todoistAPI.getALabels_invalid(id);
    }
}
