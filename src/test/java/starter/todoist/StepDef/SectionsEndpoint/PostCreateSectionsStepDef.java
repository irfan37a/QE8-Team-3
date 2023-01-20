package starter.todoist.StepDef.SectionsEndpoint;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.todoist.TodoistAPI;
import starter.todoist.Utils.Constant;

import java.io.File;

public class PostCreateSectionsStepDef {

    @Steps
    TodoistAPI toDoIstApi;

    @Given("Post Create new sections with valid json")
    public void postCreateNewSectionsWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"CreateSections.json");
        toDoIstApi.posttCreateNewSection(json);
    }

    @When("Send request post create new sections")
    public void sendRequestPostCreateNewSections() {
        SerenityRest.when().post(TodoistAPI.POST_CREATE_NEW_SECTIONS);
    }
}
