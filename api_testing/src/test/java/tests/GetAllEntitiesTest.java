package tests;

import models.AllEntityResponse;
import org.testng.annotations.Test;

public class GetAllEntitiesTest extends BaseTest {
    @Test
    public void getAllEntities() {
        requestSpecification
                .when()
                .get("getAll")
                .then()
                .statusCode(200)
                .extract()
                .as(AllEntityResponse.class);
    }
}
