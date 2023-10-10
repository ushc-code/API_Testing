package tests;

import models.EntityResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.Steps;

import static steps.Steps.getEntityResponseByID;


public class GetEntityTest  {
    public String id;

    @BeforeTest
    public void create() {
        id = Steps.createEntityStep();
    }

    @Test
    public void getEntity() {
        EntityResponse request = getEntityResponseByID(id);
        Assert.assertEquals(id, request.id, "Сущность с заданным ID не найдена");
    }
}

