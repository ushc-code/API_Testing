package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.Steps;

import static steps.Steps.deleteEntityByID;
import static steps.Steps.getErrorMessage;

public class DeleteEntityTest {
    public String id;
    @BeforeTest
    public void create() {
        id = Steps.createEntityStep();
    }

    @Test
    public void deleteEntity() {
        deleteEntityByID(id);
        Assert.assertEquals("no rows in result set", getErrorMessage(id));
    }
}

