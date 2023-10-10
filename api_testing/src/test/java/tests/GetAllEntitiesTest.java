package tests;

import models.AllEntityResponse;
import models.EntityResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.Steps;


import java.util.Objects;
import java.util.stream.Collectors;

import static steps.Steps.getAll;
import static steps.Steps.getEntityResponseByID;

public class GetAllEntitiesTest {
    String id;
    EntityResponse entityResponse;

    @BeforeTest
    public void create() {
        id = Steps.createEntityStep();
        entityResponse = getEntityResponseByID(id);
    }

    @Test
    public void getAllEntities() {
        AllEntityResponse entityList = getAll();
        Assert.assertEquals(entityList.allEntity.stream().filter(x -> Objects.equals(x.id, entityResponse.id)).collect(Collectors.counting()), 1);
    }
}
