package tests;

import models.Addition;
import models.Entity;
import models.EntityResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.Steps;

public class GetEntityTest extends BaseTest {
    public String id;
    Addition addition = new Addition("Тест", 123);
    int[] importantNumbers = {1, 2, 3};
    Entity entity = new Entity(addition, importantNumbers, "Титул", Boolean.TRUE);

    @BeforeTest
    public void create() {
        id = Steps.createEntityStep(requestSpecification, entity);
    }

    @Test
    public void getEntity() {
        EntityResponse entityResponse = requestSpecification
                .pathParam("id", id)
                .when()
                .get("get/{id}")
                .then()
                .statusCode(200)
                .extract()
                .as(EntityResponse.class);
        Assert.assertEquals(id, entityResponse.id);

    }
}
