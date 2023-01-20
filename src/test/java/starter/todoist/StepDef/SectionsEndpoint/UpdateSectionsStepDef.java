package starter.todoist.StepDef.SectionsEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;

import java.io.File;

public class UpdateSectionsStepDef {

    @Steps
    TodoistAPI toDoIstApi;

    @Given("Post Update a sections")
    public void postUpdateASections() {
        File json = new File(Constant.JSON_REQUEST+"UpdateSections.json");
        toDoIstApi.postNewComment(json);
    }

    @When("Send request post Update a sections")
    public void sendRequestPostUpdateASections() {
        SerenityRest.when().get(toDoIstApi.UPDATE_SECTIONS);
    }
}
