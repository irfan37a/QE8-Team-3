package starter.todoist.postRenameSharedLabel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;

import java.io.File;

public class RenameSharedLabelStepDefs {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Post rename shared label with valid json")
    public void postRenameSharedLabelWithValidJson() {
        File jsonValid = new File(Constant.JSON_REQUEST+"/RenameSharedLabel/RenameLabel.json");
        todoistAPI.renameSharedLabel(jsonValid);
    }

    @When("Send request post rename shared label")
    public void sendRequestPostRenameSharedLabel() {
        SerenityRest.when().post(TodoistAPI.POST_RENAME_LABEL);
    }

    @Given("Post rename shared label with invalid json")
    public void postRenameSharedLabelWithInvalidJson() {
        File jsonInvalid = new File(Constant.JSON_REQUEST+"/RenameSharedLabel/RenameLabel_Invalid.json");
        todoistAPI.renameSharedLabel(jsonInvalid);
    }

    @Given("Post rename shared label with valid json with invalid token")
    public void postRenameSharedLabelWithValidJsonWithInvalidToken() {
        File inv_token_json = new File(Constant.JSON_REQUEST+"/RenameSharedLabel/RenameLabel.json");
        todoistAPI.renameSharedLabel_invalid(inv_token_json);
    }
}
