package com.app;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import static org.junit.Assert.*;
import org.testng.annotations.*;

public class AppTest {
    @Test(dataProvider = "dataMethod") 
    public void testGetObject(JSONObject object) {
        System.out.println("Get Object with name");
        assertEquals(object , com.app.App.getObject(com.app.App.getJSONArray(), "n1"));
    }

    @DataProvider
    public Object[][] dataMethod() {
        return new Object[][] { {com.app.App.getObject(com.app.App.getJSONArray(), "n1")} };
    }

    @Test(groups="group1")
    public void testSum1() {
        System.out.println("test 1   sum");
        assertEquals(50, com.app.App.sum(20,30));
    }
    @Test(groups="group1")
    public void testSum3() {
        System.out.println("test 3   sum");
        assertEquals(5, com.app.App.sum(2,3));
    }

    @Parameters({ "first-name" })
    @Test
    public void testString(String firstName) {
        System.out.println("Invoked testString " + firstName);
        assert "Cedric".equals(firstName);
    }

}
