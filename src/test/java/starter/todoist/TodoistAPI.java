package starter.todoist;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.todoist.Utils.Constant;
import starter.todoist.Utils.TodoistResponse;

import java.io.File;
import java.net.URL;

public class TodoistAPI {

    public static String POST_NEW_COMMENT = Constant.BASE_URL + "comments";
    public static String INVALID_PATH_NEW_COMMENT = Constant.BASE_URL + "coments";
    public static String GET_ALL_COMMENT = Constant.BASE_URL + "comments?project_id={project_id}";
    public static String INVALID_PATH_GET_ALL_COMMENT = Constant.BASE_URL + "coments?project_id={project_id}";
    public static String GET_A_COMMENT = Constant.BASE_URL+"comments/{id}";
    public static String INVALID_PATH_GET_A_COMMENT = Constant.BASE_URL + "coments/{id}";
    public static String UPDATE_COMMENT = Constant.BASE_URL + "comments/{id}";


    @Step("Get a comments")
    public void getAComments(String id){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.ID, id);
    }

    @Step("Get all comments")
    public void invalidPathGetAllComments(String project_id){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.PROJECT_ID, project_id);
    }

    @Step("Get a comments")
    public void invalidPathGetComments(String id){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.ID, id);
    }

    @Step("Get a comments")
    public void invalidPathUpdateComments(String id){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.ID, id);
    }

    @Step("Get all comments")
    public void getAllComments(String project_id){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.PROJECT_ID, project_id);
    }

    @Step("Get all comments")
    public void noAuthGetAllComments(String project_id){
        SerenityRest.given()
                .pathParam(TodoistResponse.PROJECT_ID, project_id);
    }

    @Step("Get all comments")
    public void noAuthGetComments(String id){
        SerenityRest.given()
                .pathParam(TodoistResponse.ID, id);
    }

    @Step("Get all comments")
    public void emptyParamComment(){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .basePath(POST_NEW_COMMENT);
    }

    @Step("Post create comment")
    public void postNewComment(File json){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create comment")
    public void noAuthPostNewComment(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update comment")
    public void noAuthPutUpdateComment(String id,File json){
        SerenityRest.given()
                .pathParam(TodoistResponse.ID, id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update comment")
    public void putUpdateComment(String id,File json){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.ID, id)
                .contentType(ContentType.JSON)
                .body(json);
    }


}
