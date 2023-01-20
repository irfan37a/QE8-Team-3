package starter.todoist;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.todoist.Utils.Constant;
import starter.todoist.Utils.TodoistResponse;

import java.io.File;
import java.net.URL;

public class TodoistAPI {

    public static String POST_CREATE_LABEL = Constant.BASE_URL + "labels";
    public static String GET_A_LABEL = Constant.BASE_URL + "labels/{id}";
    public static String DELETE_A_LABEL = Constant.BASE_URL + "labels/{id}";
    public static String GET_ALL_LABELS = Constant.BASE_URL + "labels";
    public static String POST_UPDATE_LABEL = Constant.BASE_URL + "labels/{id}";
    public static String POST_REOPEN_TASK = Constant.BASE_URL + "tasks/{id}/reopen";
    public static String POST_RENAME_LABEL = Constant.BASE_URL + "labels/shared/rename";
    public static String POST_REMOVE_LABEL = Constant.BASE_URL + "labels/shared/remove";
    public static String GET_ALL_SHARED_LABELS = Constant.BASE_URL + "labels/shared";
    public static String POST_UPDATE_TASK = Constant.BASE_URL + "tasks/{id}";
    public static String POST_NEW_COMMENT = Constant.BASE_URL + "comments";
    public static String INVALID_PATH_NEW_COMMENT = Constant.BASE_URL + "coments";
    public static String GET_ALL_COMMENT = Constant.BASE_URL + "comments?project_id={project_id}";
    public static String INVALID_PATH_GET_ALL_COMMENT = Constant.BASE_URL + "coments?project_id={project_id}";
    public static String GET_A_COMMENT = Constant.BASE_URL+"comments/{id}";
    public static String INVALID_PATH_GET_A_COMMENT = Constant.BASE_URL + "coments/{id}";
    public static String UPDATE_COMMENT = Constant.BASE_URL + "comments/{id}";
    public static String GET_ACTIVE_TASK = Constant.BASE_URL+"tasks/{id}";
    public static String GET_ACTIVE_TASK2 = Constant.BASE_URL+"tasks";
    public static String INVALID_GET_ACTIVE_TASK = Constant.BASE_URL+"task/{id}";
    public static String CLOSE_TASK = Constant.BASE_URL+"tasks/{id}/close";
    public static String INVALID_CLOSE_TASK = Constant.BASE_URL+"tasks/{id}/closse";

    public static String GET_ALL_SECTIONS = Constant.BASE_URL+"sections?project_id={project_id}";
    public static String GET_SINGLE_SECTIONS = Constant.BASE_URL+"sections?id={id}";
    public static String POST_CREATE_NEW_SECTIONS = Constant.BASE_URL+"sections";

    public static String UPDATE_SECTIONS = Constant.BASE_URL+"sections/7025";

    public static String DELETE_SECTIONS = Constant.BASE_URL + "sections/{id}";
    public static String DELETE_TASK = Constant.BASE_URL + "tasks/{id}";


    @Step("Post create label")
    public void postCreateLabel(File json) {
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .contentType(ContentType.JSON)
                .body(json);
    }


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

    @Step("Post create label invalid token")
    public void postCreateLabel_inv_token(File json) {
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b211";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization", authToken)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create comment")
    public void noAuthPostNewComment(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step("Get all labels valid token")
    public void getAllLabels(){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get all labels invalid token")
    public void getAllLabels_inv_token(){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b211";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get a labels valid token")
    public void getALabels(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Get a labels invalid id")
    public void getALabels_invalid(int id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Get a labels valid id invalid token")
    public void getALabels_invalid_token(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b2e1";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Post Update a label valid token")
    public void UpdateALabel(String id, File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Authorization",authToken)
                .pathParam("id",id)
                .body(json);
    }

    @Step("Post Update a labels invalid token")
    public void UpdateALabel_invalid_token(String id, File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b211";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Authorization",authToken)
                .pathParam("id",id)
                .body(json);
    }

    @Step("Update a label with invalid id")
    public void UpdateALabel_invalid_id(int id, File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Authorization",authToken)
                .pathParam("id",id)
                .body(json);
    }

    @Step("Delete label")
    public void deleteLabel(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Delete label with String id")
    public void deleteLabel_invalidId(int id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Delete label with invalid token")
    public void deleteLabel_invalidToken(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b2111";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Reopen a task")
    public void reopenTask(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Reopen a task with invalid id")
    public void reopenTask_invalidId(int id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Reopen a task")
    public void reopenTask_invalidToken(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21111";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Get all labels valid token")
    public void getAllSharedLabels(){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get all labels invalid token")
    public void getAllSharedLabels_inv_token(){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b211";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Rename a shared label")
    public void renameSharedLabel(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Authorization",authToken)
                .body(json);
    }

    @Step("Rename a shared label invalid")
    public void renameSharedLabel_invalid(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b2aa1";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Authorization",authToken)
                .body(json);
    }

    @Step("Remove a shared label")
    public void removeSharedLabel(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Authorization",authToken)
                .body(json);
    }

    @Step("Remove a shared label")
    public void removeSharedLabel_invalid(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21sda";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Authorization",authToken)
                .body(json);
    }

    @Step("Update a task label")
    public void updateATaskid(String id,File json) {
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", authToken)
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

    @Step("Update a task label with invalid token")
    public void updateATaskid_invalid_token(String id,File json) {
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b2ee1";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", authToken)
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

    @Step("Delete comment")
    public void deleteComment(String id){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.ID,id);
    }

    @Step("Delete comment")
    public void noAuthDeleteComment(String id){
        SerenityRest.given()
                .pathParam(TodoistResponse.ID,id);
    }

    @Step("Get active task")
    public void getActiveTask(String id){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.ID, id);
    }

    @Step("Get active task")
    public void noAuthGetActiveTask(String id){
        SerenityRest.given()
                .pathParam(TodoistResponse.ID, id);
    }


    @Step("Close task")
    public void closeTask(String id){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.ID, id);
    }

    @Step("Close task")
    public void noAuthCloseTask(String id){
        SerenityRest.given()
                .pathParam(TodoistResponse.ID, id);
    }
    @Step
    public void getAllLSections(String project_id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.PROJECT_ID, project_id);
    }

    @Step("Delete Sections")
    public void deleteSections(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step("Get active task")
    public void getActiveTask2(){
        String token = "6cbd35bffb18682aba3874e9563f7f3d0d3b6ada";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken);
    }
    @Step("Delete Task")
    public void deleteTask(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id);
    }

    @Step
    public void getSingleSections(String id){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam(TodoistResponse.ID, id);
    }
}
