package starter.todoist;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.todoist.Utils.Constant;

import java.io.File;
import java.net.URL;

public class TodoistAPI {

    public static String POST_NEW_COMMENT = Constant.BASE_URL + "comments";


    @Step("Post create users")
    public void postNewComment(File json){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .contentType(ContentType.JSON)
                .body(json);
    }


}
