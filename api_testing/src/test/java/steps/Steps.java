package steps;

import helpers.PropertyProvider;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.*;

import static io.restassured.RestAssured.given;

public class Steps {
    static String uri = PropertyProvider.getInctance().getProperty("uri");
    static String pathCreate = PropertyProvider.getInctance().getProperty("pathCreate");
    static String pathGet = PropertyProvider.getInctance().getProperty("pathGet");
    static String pathGetAll = PropertyProvider.getInctance().getProperty("pathGetAll");
    static String pathUpdate = PropertyProvider.getInctance().getProperty("pathUpdate");
    static String pathDelete = PropertyProvider.getInctance().getProperty("pathDelete");
    static Addition addition = new Addition("Тест", 123);
    static int[] importantNumbers = {1, 2, 3};
    static Entity entity = new Entity(addition, importantNumbers, "Титул", Boolean.TRUE);
    public static Entity updateEntity = new Entity(addition, importantNumbers, "Измененный титул", Boolean.TRUE);
    protected static final RequestSpecification requestSpecification = given()
            .baseUri(uri)
            .contentType(ContentType.JSON)
            .queryParam("v", "5.131");

    public static String createEntityStep() {
        return requestSpecification
                .body(entity)
                .post(pathCreate)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
    }

    public static ExtractableResponse<Response> getEntityByID(String id) {
        return requestSpecification
                .pathParam("id", id)
                .when()
                .get(pathGet)
                .then()
                .extract();
    }

    public static EntityResponse getEntityResponseByID(String id) {
        return getEntityByID(id).as(EntityResponse.class);
    }

    public static String getIDEntity(String id) {
        return getEntityByID(id).as(EntityResponse.class).id;
    }

    public static ExtractableResponse<Response> deleteEntityByID(String id) {
        return requestSpecification
                .pathParam("id", id)
                .when()
                .delete(pathDelete)
                .then()
                .statusCode(204)
                .extract();
    }

    public static String getErrorMessage(String id) {
        return getEntityByID(id).as(ResponseError.class).errorMessage;
    }

    public static ExtractableResponse<Response> updateEntityByID(String id) {
        return requestSpecification
                .body(updateEntity)
                .pathParam("id", id)
                .when()
                .patch(pathUpdate)
                .then()
                .statusCode(204)
                .extract();
    }

    public static AllEntityResponse getAll() {
        RequestSpecification requestSpecificationForGetAll = given()
                .baseUri("http://localhost:8080/api/")
                .contentType(ContentType.JSON)
                .queryParam("v", "5.131");
        ;
        return requestSpecificationForGetAll
                .get(pathGetAll)
                .then()
                .statusCode(200)
                .extract()
                .as(AllEntityResponse.class);
    }
}

