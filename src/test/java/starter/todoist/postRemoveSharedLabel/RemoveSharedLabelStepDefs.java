package starter.todoist.postRemoveSharedLabel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;

import java.io.File;

public class RemoveSharedLabelStepDefs {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Remove Shared Label with valid json")
    public void removeSharedLabelWithValidJson() {
        File jsonRemove = new File(Constant.JSON_REQUEST+"/RemoveSharedLabel/RemoveLabel.json");
        todoistAPI.removeSharedLabel(jsonRemove);
    }

    @When("Send request Remove Shared Label")
    public void sendRequestRemoveSharedLabel() {
        SerenityRest.when().post(TodoistAPI.POST_REMOVE_LABEL);
    }

    @Given("Delete label with invalid json")
    public void deleteLabelWithInvalidJson() {
        File jsonRemove_invalid = new File(Constant.JSON_REQUEST+"/RemoveSharedLabel/RemoveLabel_invalid.json");
        todoistAPI.removeSharedLabel(jsonRemove_invalid);
    }

    @Given("Delete label with valid json with invalid token")
    public void deleteLabelWithValidJsonWithInvalidToken() {
        File jsonRemove = new File(Constant.JSON_REQUEST+"/RemoveSharedLabel/RemoveLabel.json");
        todoistAPI.removeSharedLabel_invalid(jsonRemove);
    }
}
