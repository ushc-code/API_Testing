package tests;

import models.Addition;
import models.Entity;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.Steps;

import static steps.Steps.getErrorMessage;

public class DeleteEntityTest extends BaseTest {
    public String id;
    Addition addition = new Addition("Тест", 123);
    int[] importantNumbers = {1, 2, 3};
    Entity entity = new Entity(addition, importantNumbers, "Титул", Boolean.TRUE);

    @BeforeTest
    public void create() {
        id = Steps.createEntityStep(requestSpecification, entity);
    }

    @Test
    public void deleteEntity() {
        requestSpecification
                .pathParam("id", id)
                .when()
                .delete("delete/{id}")
                .then()
                .statusCode(204);
        Assert.assertEquals("no rows in result set", getErrorMessage(requestSpecification, id));
    }
}
