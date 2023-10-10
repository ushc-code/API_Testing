package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.Steps;

import static steps.Steps.*;

public class UpdateEntityTest  {
    public String id;

    @BeforeTest
    public void create() {
        id = Steps.createEntityStep();
    }

    @Test
    public void updateEntity() {
        updateEntityByID(id);
        Assert.assertEquals(updateEntity.title, getEntityResponseByID(id).title);
    }
}
