package starter.todoist.StepDef.SectionsEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class DeleteSectionsStepDef {

    @Steps
    TodoistAPI todoistAPI;

    @Given("Delete sections with valid {string}")
    public void deleteSectionsWithValid(String id) {
        todoistAPI.deleteSections(id);
    }

    @When("Send request delete sections")
    public void sendRequestDeleteSections() {
        SerenityRest.when().delete(TodoistAPI.DELETE_SECTIONS);
    }
}
