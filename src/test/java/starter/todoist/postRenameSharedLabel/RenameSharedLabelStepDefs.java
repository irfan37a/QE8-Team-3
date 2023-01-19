package starter.todoist.postRenameSharedLabel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;
import starter.todoist.Utils.TodoistResponses;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;
public class RenameSharedLabelStepDefs {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Post rename shared label with valid json")
    public void postRenameSharedLabelWithValidJson() {
        File jsonValid1 = new File(Constant.JSON_REQUEST+"/RenameSharedLabel/RenameLabel.json");
        todoistAPI.renameSharedLabel(jsonValid1);
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

    @Given("Post rename shared label with empty json")
    public void postRenameSharedLabelWithEmptyJson() {
        File empty_json = new File(Constant.JSON_REQUEST+"/RenameSharedLabel/RenameLabel_empty.json");
        todoistAPI.renameSharedLabel(empty_json);
    }
}
