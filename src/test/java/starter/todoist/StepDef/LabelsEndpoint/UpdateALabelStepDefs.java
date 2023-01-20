package starter.todoist.StepDef.LabelsEndpoint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;
import starter.todoist.Utils.TodoistResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateALabelStepDefs {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Update a label with valid id {string} with valid json")
    public void updateALabelWithValidId(String id) {
        File validJson_label = new File(Constant.JSON_REQUEST+"UpdateLabel.json");
        todoistAPI.UpdateALabel(id,validJson_label);
    }

    @When("Send request update a label")
    public void sendRequestUpdateALabel() {
        SerenityRest.when().post(TodoistAPI.POST_UPDATE_LABEL);
    }

    @And("Validate body page same as update a label schema")
    public void validateBodyPageSameAsUpdateALabelSchema() {
        File successJsonSchema = new File(Constant.JSON_SCHEMA+"ValidUpdateALabel_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(successJsonSchema));
    }

    @Given("Update a label with valid id {string} but invalid token")
    public void updateALabelWithValidIdButInvalidToken(String id) {
        File validJson_token = new File(Constant.JSON_REQUEST+"UpdateLabel.json");
        todoistAPI.UpdateALabel_invalid_token(id,validJson_token);
    }

    @Given("Update a label with valid id {string} and valid json")
    public void updateALabelWithValidIdAndValidJson(String id) {
        File validJson = new File(Constant.JSON_REQUEST+"UpdateLabel.json");
        todoistAPI.UpdateALabel(id,validJson);
    }

    @And("Response label body id should be {string}")
    public void responseLabelBodyIdShouldBe(String id) {
        SerenityRest.then().body(TodoistResponses.ID,equalTo(id));
    }

    @Given("Update a label with invalid id {int} but valid json")
    public void updateALabelWithInvalidIdButValidJson(int id) {
        File validJson = new File(Constant.JSON_REQUEST+"UpdateLabel.json");
        todoistAPI.UpdateALabel_invalid_id(id,validJson);
    }

    @Given("Update a label with valid id {string} with invalid json")
    public void updateALabelWithValidIdWithInvalidJson(String id) {
        File validJson_invalid = new File(Constant.JSON_REQUEST+"UpdateLabel_invalid.json");
        todoistAPI.UpdateALabel(id,validJson_invalid);
    }

    @Given("Update a label with valid id {string} with empty json")
    public void updateALabelWithValidIdWithEmptyJson(String id) {
            File validJson_empty = new File(Constant.JSON_REQUEST+"UpdateLabel_empty.json");
            todoistAPI.UpdateALabel(id,validJson_empty);
    }
}
