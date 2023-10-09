package tests;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

abstract public class BaseTest {
    protected final RequestSpecification requestSpecification = given()
            .baseUri("http://localhost:8080/api/")
            .contentType(ContentType.JSON)
            .queryParam("v", "5.131");

}
