package starter.todoist.postCreateLabel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;
import starter.todoist.Utils.TodoistResponses;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class CreateLabelStepdefs {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Post create label with valid json")
    public void postCreateLabelWithValidJson() {
        File valid_json = new File(Constant.JSON_REQUEST+"/CreateLabel/CreateLabel.json");
        todoistAPI.postCreateLabel(valid_json);
    }

    @When("Send request post create label")
    public void sendRequestPostCreateLabel() {
        SerenityRest.when().post(TodoistAPI.POST_CREATE_LABEL);
    }

    @Then("API should return status code {int}")
    public void shouldReturnStatusCode(int status_code) {
        SerenityRest.then().statusCode(status_code);
    }

    @And("Validate json schema create new label")
    public void validateJsonSchemaCreateNewLabel() {
        File successJsonSchema = new File(Constant.JSON_SCHEMA+"/ValidLabel_Schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(successJsonSchema));
    }

    @Given("Post create label with invalid json")
    public void postCreateLabelWithInvalidJson() {
        File invalid_json = new File(Constant.JSON_REQUEST+"/CreateLabel/CreateLabel_invalid.json");
        todoistAPI.postCreateLabel(invalid_json);
    }

    @Given("Post create label with empty name")
    public void postCreateLabelWithEmptyName() {
        File empty_json = new File(Constant.JSON_REQUEST+"/CreateLabel/CreateLabel_empty.json");
        todoistAPI.postCreateLabel(empty_json);
    }


    @Given("Post create label with valid json invalid token")
    public void postCreateLabelWithValidJsonInvalidToken() {
        File valid_json = new File(Constant.JSON_REQUEST+"/CreateLabel/CreateLabel.json");
        todoistAPI.postCreateLabel_inv_token(valid_json);
    }
}
