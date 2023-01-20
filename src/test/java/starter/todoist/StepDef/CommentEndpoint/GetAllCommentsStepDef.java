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

public class GetAllCommentsStepDef {
    @Steps
    TodoistAPI toDoIstApi;


    @Given("Get all comments with valid project id {string}")
    public void getAllCommentsWithValidProjectId(String project_id) {
        toDoIstApi.getAllComments(project_id);
    }

    @When("Send request get all comments")
    public void sendRequestGetAllComments() {
        SerenityRest.when()
                .get(toDoIstApi.GET_ALL_COMMENT);
    }

    @And("Validate json schema get all comments")
    public void validateJsonSchemaGetAllComments() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"GetAllCommentSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    @And("Response body page should be project_id {string}")
    public void responseBodyPageShouldBeProject_id(String project_id) {
        SerenityRest.then().body(TodoistResponse.PROJECT_ID,hasItem(project_id));

    }

    @Given("Get all comments with invalid project id {string}")
    public void getAllCommentsWithInvalidProjectId(String project_id) {
        toDoIstApi.getAllComments(project_id);
    }

    @Given("Get all comments without project id")
    public void getAllCommentsWithoutProjectId() {
        toDoIstApi.emptyParamComment();
    }

    @When("Send request get all comments without project id")
    public void sendRequestGetAllCommentsWithoutProjectId() {
        SerenityRest.when()
                .get(toDoIstApi.POST_NEW_COMMENT);
    }

    @Given("Get all comments without authentication")
    public void getAllCommentsWithoutAuthentication() {
        String project_id = "2306143459";
        toDoIstApi.noAuthGetAllComments(project_id);
    }

    @Given("Get all comments with invalid path")
    public void getAllCommentsWithInvalidPath() {
        String project_id = "2306143459";
        toDoIstApi.invalidPathGetAllComments(project_id);
    }

    @When("Send request get all comments with invalid path")
    public void sendRequestGetAllCommentsWithInvalidPath() {
        SerenityRest.when()
                .get(toDoIstApi.INVALID_PATH_GET_ALL_COMMENT);
    }
}
