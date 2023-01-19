package starter.todoist.postUpdateTask;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;
import starter.todoist.Utils.TodoistResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateTaskStepdefs {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Update a task with valid json and id {string}")
    public void putUpdateUserWithValidJson(String id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateTask/UpdateTask.json");
        todoistAPI.updateATaskid(id, json);
    }

    @When("Send request post update task")
    public void sendRequestPostUpdateComment() {
        SerenityRest.when().post(TodoistAPI.POST_UPDATE_TASK);
    }

    @And("Response body id should be {string}")
    public void responseBodyIdShouldBe(String id) {
        SerenityRest.then().body(TodoistResponses.ID,equalTo(id));
    }

    @Given("Update a task with valid json and invalid id {string}")
    public void updateATaskWithValidJsonAndInvalidId(String id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateTask/UpdateTask.json");
        todoistAPI.updateATaskid(id, json);
    }

    @Given("Update a task with invalid json and id {string}")
    public void updateATaskWithInvalidJsonAndId(String id) {
        File invalidjson = new File(Constant.JSON_REQUEST+"/UpdateTask/UpdateTask_invalid.json");
        todoistAPI.updateATaskid(id, invalidjson);
    }

    @Given("Update a task with empty json and id {string}")
    public void updateATaskWithEmptyJsonAndId(String id) {
        File emptyjson = new File(Constant.JSON_REQUEST+"/UpdateTask/UpdateTask_empty.json");
        todoistAPI.updateATaskid(id, emptyjson);
    }

    @Given("Update a task with valid json and id {string} with invalid token")
    public void updateATaskWithValidJsonAndIdWithInvalidToken(String id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateTask/UpdateTask.json");
        todoistAPI.updateATaskid_invalid_token(id, json);
    }
}
