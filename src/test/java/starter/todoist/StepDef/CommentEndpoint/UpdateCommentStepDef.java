package starter.todoist.StepDef.CommentEndpoint;

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

public class UpdateCommentStepDef {
    @Steps
    TodoistAPI toDoIstApi;

    @Given("Update a comment with valid json and id {string}")
    public void putUpdateUserWithValidJson(String id) {
        File json = new File(Constant.JSON_REQUEST+"UpdateComment.json");
        toDoIstApi.putUpdateComment(id, json);
    }

    @When("Send request post update comment")
    public void sendRequestPostUpdateComment() {
        SerenityRest.when()
                .post(toDoIstApi.UPDATE_COMMENT);
    }

    @And("Response body id should be {string}")
    public void responseBodyIdShouldBe(String id) {
        SerenityRest.then().body(TodoistResponse.ID,equalTo(id));
    }

    @And("Validate json schema update a comment")
    public void validateJsonSchemaUpdateAComment() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"UpdateCommentSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Update a comment with invalid id {string}")
    public void updateACommentWithInvalidId(String id) {
        File json = new File(Constant.JSON_REQUEST+"UpdateComment.json");
        toDoIstApi.putUpdateComment(id, json);
    }

    @Given("Update a comment without authentication")
    public void updateACommentWithoutAuthentication() {
        File json = new File(Constant.JSON_REQUEST+"UpdateComment.json");
        String id = "3206497169";
        toDoIstApi.noAuthPutUpdateComment(id, json);
    }

    @Given("Update a comment with invalid json")
    public void updateACommentWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST+"InvalidUpdateComment.json");
        String id = "3206497169";
        toDoIstApi.putUpdateComment(id, json);
    }

    @Given("Update a comment with valid id and empty json key")
    public void updateACommentWithValidIdAndEmptyJsonKey() {
        File json = new File(Constant.JSON_REQUEST+"EmptyUpdateComment.json");
        String id = "3206497169";
        toDoIstApi.putUpdateComment(id, json);
    }

    @Given("Update a comment with valid id")
    public void updateACommentWithValidIdButInvalidPath() {
        String id = "3206497169";
        toDoIstApi.invalidPathUpdateComments(id);
    }

    @When("Send request post update comment with invalid path")
    public void sendRequestPostUpdateCommentWithInvalidPath() {
        SerenityRest.when()
                .post(toDoIstApi.INVALID_PATH_GET_A_COMMENT);
    }
}
