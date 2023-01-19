package starter.todoist;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.todoist.Utils.Constant;

import java.io.File;

public class TodoistAPI {

    public static String POST_CREATE_LABEL = Constant.BASE_URL + "/labels";
    public static String GET_A_LABEL = Constant.BASE_URL + "/labels/{id}";
    public static String DELETE_A_LABEL = Constant.BASE_URL + "/labels/{id}";
    public static String GET_ALL_LABELS = Constant.BASE_URL + "/{labels}";
    public static String POST_UPDATE_LABEL = Constant.BASE_URL + "/labels/{id}";
    public static String POST_REOPEN_TASK = Constant.BASE_URL + "/tasks/{id}/reopen";
    public static String POST_RENAME_LABEL = Constant.BASE_URL + "/labels/shared/rename";
    public static String POST_REMOVE_LABEL = Constant.BASE_URL + "/labels/shared/remove";
    public static String GET_ALL_SHARED_LABELS = Constant.BASE_URL + "/{labels}/shared";
    public static String POST_UPDATE_TASK = Constant.BASE_URL + "/tasks/{id}";

    @Step("Post create label")
    public void postCreateLabel(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create label invalid token")
    public void postCreateLabel_inv_token(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b211";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get all labels valid token")
    public void getAllLabels(String labels){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("labels",labels);
    }

    @Step("Get all labels invalid token")
    public void getAllLabels_inv_token(String labels){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b211";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("labels",labels);
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

    @Step("Update a label valid token")
    public void UpdateALabel(String id, File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id)
                .body(json);
    }

    @Step("Update a labels invalid token")
    public void UpdateALabel_invalid_token(String id, File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b211";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("id",id)
                .body(json);
    }

    @Step("Update a label with invalid id")
    public void UpdateALabel_invalid_id(int id, File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
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
    public void getAllSharedLabels(String labels){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("labels",labels);
    }

    @Step("Get all labels invalid token")
    public void getAllSharedLabels_inv_token(String labels){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b211";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .pathParam("labels",labels);
    }

    @Step("Rename a shared label")
    public void renameSharedLabel(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .body(json);
    }

    @Step("Rename a shared label invalid")
    public void renameSharedLabel_invalid(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b2aa1";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .body(json);
    }

    @Step("Remove a shared label")
    public void removeSharedLabel(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .body(json);
    }

    @Step("Remove a shared label")
    public void removeSharedLabel_invalid(File json){
        String token = "bf57e110ca3d532fcbfb0e810e858518bb1b8b21sda";
        String authToken = "Bearer " + token;

        SerenityRest.given()
                .headers("Authorization",authToken)
                .body(json);
    }

}
