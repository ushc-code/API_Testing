package tests;

import models.Addition;
import models.Entity;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.Steps;


import static steps.Steps.getEntityByID;

public class UpdateEntityTest extends BaseTest {
    Addition addition = new Addition("Тест", 123);
    int[] importantNumbers = {1, 2, 3};
    Entity entity = new Entity(addition, importantNumbers, "Титул", Boolean.TRUE);
    Entity updateEntity = new Entity(addition, importantNumbers, " Новый Титул", Boolean.TRUE);

    public String id;


    @BeforeTest
    public void create() {
        id = Steps.createEntityStep(requestSpecification, entity);
    }

    @Test
    public void updateEntity() {
        requestSpecification
                .body(updateEntity)
                .pathParam("id", id)
                .when()
                .patch("patch/{id}")
                .then()
                .statusCode(204);
        Assert.assertEquals(updateEntity.title, getEntityByID(requestSpecification, id).title);
    }
}
