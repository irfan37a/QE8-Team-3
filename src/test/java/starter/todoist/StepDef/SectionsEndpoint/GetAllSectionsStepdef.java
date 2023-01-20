package starter.todoist.StepDef.SectionsEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;

public class GetAllSectionsStepdef {

    @Steps
    TodoistAPI toDoIstApi;


    @Given("Get all section with valid project id {string}")
    public void getAllSectionWithValidProjectId(String project_id) {
        toDoIstApi.getAllLSections(project_id);
    }
    @When("Send request get all sections")
    public void sendRequestGetAllSections() {
        SerenityRest.when().get(toDoIstApi.GET_ALL_SECTIONS);
    }

}
