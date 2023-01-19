package starter.todoist.StepDef.CommentEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class DeleteCommentStepDef {
    @Steps
    TodoistAPI toDoIstApi;

    @Given("Delete a comment with valid id {string}")
    public void deleteUserWithValidIdId(String id) {
        toDoIstApi.deleteComment(id);
    }

    @When("Send request delete a comment")
    public void sendRequestDeleteAComment() {
        SerenityRest.when()
                .delete(toDoIstApi.UPDATE_COMMENT);
    }

    @Given("Delete a comment with invalid id {string}")
    public void deleteACommentWithInvalidId(String id) {
        toDoIstApi.deleteComment(id);
    }

    @Given("Delete a comment without authentication")
    public void deleteACommentWithoutAuthentication() {
        String id = "3206497169";
        toDoIstApi.noAuthDeleteComment(id);
    }

    @Given("Deleta a comment with unregistered id {string}")
    public void deletaACommentWithUnregisteredId(String id) {
        toDoIstApi.deleteComment(id);
    }

    @Given("Delete a comment with valid id")
    public void deleteACommentWithInvalidPath() {
        String id = "3206497169";
        toDoIstApi.deleteComment(id);
    }

    @When("Send request delete a comment with invalid path")
    public void sendRequestDeleteACommentWithInvalidPath() {
        SerenityRest.when()
                .delete(toDoIstApi.INVALID_PATH_GET_A_COMMENT);
    }
}
