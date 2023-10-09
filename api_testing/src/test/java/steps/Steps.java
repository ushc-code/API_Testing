package steps;

import io.restassured.specification.RequestSpecification;
import models.Entity;
import models.EntityResponse;
import models.ResponseError;

public class Steps {


    public static String createEntityStep(RequestSpecification requestSpecification, Entity entity) {
        return requestSpecification
                .body(entity)
                .post("create")
                .then()
                .extract()
                .body()
                .asString();
    }

    public static EntityResponse getEntityByID(RequestSpecification requestSpecification, String id) {
        return requestSpecification
                .pathParam("id", id)
                .when()
                .get("get/{id}")
                .then()
                .extract()
                .as(EntityResponse.class);
    }

    public static String getIDEntity(RequestSpecification requestSpecification, String id) {
        EntityResponse entityResponse = requestSpecification
                .pathParam("id", id)
                .when()
                .get("get/{id}")
                .then()
                .extract()
                .body()
                .as(EntityResponse.class);
        return entityResponse.id;
    }

    public static String getErrorMessage(RequestSpecification requestSpecification, String id) {
        ResponseError response = requestSpecification
                .pathParam("id", id)
                .when()
                .get("get/{id}")
                .then()
                .extract()
                .body()
                .as(ResponseError.class);
        return response.errorMessage;
    }
}

