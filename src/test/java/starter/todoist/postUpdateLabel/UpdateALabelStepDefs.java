package starter.todoist.postUpdateLabel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;

import java.io.File;

public class UpdateALabelStepDefs {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Update a label with valid id {string} with valid json")
    public void updateALabelWithValidId(String id) {
        File validJson = new File(Constant.JSON_REQUEST+"/UpdateLabel/UpdateLabel.json");
        todoistAPI.UpdateALabel(id,validJson);
    }

    @When("Post update a label {string} same as json")
    public void postUpdateALabelSameAsJson(String id) {
        File validJson = new File(Constant.JSON_REQUEST+"/UpdateLabel/UpdateLabel.json");
        todoistAPI.UpdateALabel(id,validJson);
    }

    @And("Send request update a label")
    public void sendRequestUpdateALabel() {
        SerenityRest.when().post(TodoistAPI.POST_UPDATE_LABEL);
    }

    @And("Validate body page same as update a label schema")
    public void validateBodyPageSameAsUpdateALabelSchema() {
        File successJsonSchema = new File(Constant.JSON_SCHEMA+"/ValidUpdateALabel_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(successJsonSchema));
    }

    @Given("Update a label with invalid id {int}")
    public void updateALabelWithInvalidIdId(int id) {
        File validJson = new File(Constant.JSON_REQUEST+"/UpdateLabel/UpdateLabel.json");
        todoistAPI.UpdateALabel_invalid_id(id, validJson);
    }

    @Given("Update a label with valid id {string} but invalid token")
    public void updateALabelWithValidIdButInvalidToken(String id) {
        File validJson = new File(Constant.JSON_REQUEST+"/UpdateLabel/UpdateLabel.json");
        todoistAPI.UpdateALabel_invalid_token(id,validJson);
    }

    @When("Post update a label same as invalid json")
    public void postUpdateALabelSameAsInvalidJson(String id) {
        File validJson = new File(Constant.JSON_REQUEST+"/UpdateLabel/UpdateLabel_invalid.json");
        todoistAPI.UpdateALabel(id,validJson);
    }

    @When("Post update a label with kd {string} with empty json")
    public void postUpdateALabelSameAsEmptyJson(String id) {
        File validJson = new File(Constant.JSON_REQUEST+"/UpdateLabel/UpdateLabel_empty.json");
        todoistAPI.UpdateALabel(id,validJson);
    }
}
