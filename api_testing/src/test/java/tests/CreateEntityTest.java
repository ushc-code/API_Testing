package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static steps.Steps.createEntityStep;
import static steps.Steps.getIDEntity;


public class CreateEntityTest {
    @Test
    public void createEntity() {
        String request = createEntityStep();
        Assert.assertEquals(request, getIDEntity(request), "Сущность с заданным ID не найдена");
    }
}
