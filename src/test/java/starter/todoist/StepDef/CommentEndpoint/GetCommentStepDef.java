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
import static org.hamcrest.Matchers.hasItem;

public class GetCommentStepDef {
    @Steps
    TodoistAPI toDoIstApi;

    @Given("Get a comment with valid parameter id {string}")
    public void getAllCommentsWithValidProjectId(String id) {
        toDoIstApi.getAComments(id);
    }

    @When("Send request get a comment")
    public void sendRequestGetAComment() {
        SerenityRest.when()
                .get(toDoIstApi.GET_A_COMMENT);
    }

    @And("Response body page should be id {string}")
    public void responseBodyPageShouldBeId(String id) {
        SerenityRest.then().body(TodoistResponse.ID,equalTo(id));
    }

    @And("Validate json schema get a comment")
    public void validateJsonSchemaGetAComment() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"GetCommentSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get a comment with invalid parameter id {string}")
    public void getACommentWithInvalidParameterId(String id) {
        toDoIstApi.getAComments(id);
    }

    @When("Send request get a comment without parameter id")
    public void sendRequestGetACommentWithoutParameterId() {
        SerenityRest.when()
                .get(toDoIstApi.POST_NEW_COMMENT);
    }

    @Given("Get a comment without parameter id")
    public void getACommentWithoutParameterId() {
        toDoIstApi.emptyParamComment();
    }

    @Given("Get a comments without authentication")
    public void getACommentsWithoutAuthentication() {
        String id = "3206497169";
        toDoIstApi.noAuthGetComments(id);
    }

    @Given("Get a comment with invalid path")
    public void getACommentWithInvalidPath() {
        String id = "3206497169";
        toDoIstApi.invalidPathGetComments(id);
    }

    @When("Send request get a comments with invalid path")
    public void sendRequestGetACommentsWithInvalidPath() {
        SerenityRest.when()
                .get(toDoIstApi.INVALID_PATH_GET_A_COMMENT);
    }
}
