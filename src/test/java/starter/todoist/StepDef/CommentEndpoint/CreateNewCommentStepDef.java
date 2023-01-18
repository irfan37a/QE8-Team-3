package starter.todoist.StepDef.CommentEndpoint;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;
import starter.todoist.Utils.TodoistResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateNewCommentStepDef {
    @Steps
    TodoistAPI toDoIstApi;

    @Given("Post comment with valid json")
    public void postCommentWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"CreateComment.json");
        toDoIstApi.postNewComment(json);
    }


    @When("Send request post new comment")
    public void sendRequestPostCreateUser() {
        SerenityRest.when()
                .post(toDoIstApi.POST_NEW_COMMENT);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body project_id should be {string}")
    public void responseBodyNameShouldBeAndJobShouldBe(String projectid) {
        SerenityRest.then()
                .body(TodoistResponse.PROJECT_ID, equalTo(projectid));
    }

    @And("Validate json schema create new comment")
    public void validateJsonSchemaCreateNewComment() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"CreateCommentSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
