package starter.todoist.StepDef.SectionsEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class GetSingleSectionsStepDef {
    @Steps
    TodoistAPI toDoIstApi;

    @Given("Get a single sections id {string}")
    public void getASingleSectionsId(String id) {
        toDoIstApi.getSingleSections(id);
    }

    @When("Send request get a single sections")
    public void sendRequestGetASingleSections() {
        SerenityRest.when().get(toDoIstApi.GET_SINGLE_SECTIONS);
    }
}
