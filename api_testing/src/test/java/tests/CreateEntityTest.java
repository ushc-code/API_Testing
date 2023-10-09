package tests;

import models.Addition;
import models.Entity;
import org.testng.Assert;
import org.testng.annotations.Test;

import static steps.Steps.getIDEntity;


public class CreateEntityTest extends BaseTest {
    Addition addition = new Addition("Тест", 123);
    int[] importantNumbers = {1, 2, 3};
    Entity entity = new Entity(addition, importantNumbers, "Титул", Boolean.TRUE);


    @Test
    public void createEntity() {
        String request = requestSpecification
                .body(entity)
                .post("create")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        Assert.assertEquals(request, getIDEntity(requestSpecification, request));
    }
}
