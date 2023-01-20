package starter.todoist.StepDef.LabelsEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class DeleteLabelStepdefs {
    @Steps
    TodoistAPI todoistAPI;

    @Given("Delete label with valid {string}")
    public void deleteLabelWithValid(String id) {
        todoistAPI.deleteLabel(id);
    }

    @When("Send request delete label")
    public void sendRequestDeleteLabel() {
        SerenityRest.when().delete(TodoistAPI.DELETE_A_LABEL);
    }

    @Given("Delete label with invalid {int}")
    public void deleteLabelWithInvalidId(int id) {
        todoistAPI.deleteLabel_invalidId(id);
    }

    @Given("Delete label with valid {string} with invalid token")
    public void deleteLabelWithValidWithInvalidToken(String id) {
        todoistAPI.deleteLabel_invalidToken(id);
    }
}
