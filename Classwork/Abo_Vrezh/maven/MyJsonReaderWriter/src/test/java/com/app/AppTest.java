package com.app;

import org.junit.Test;
//import org.junit.TestCase;
//import org.junit.TestSuite;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.json.simple.JSONObject;

/**
 * Unit test for simple App.
 */

//extends TestCase 
public class AppTest {
    App app;

    @Before
    public void init() {
        app = new App();
        System.out.println("Before");
    }

    @Test
    public void testGetObject() {
        JSONObject jsonObj = new JSONObject("[{\"homeworks\":[\"h1\",\"h2\",\"h3\"],\"surname\":\"sn1\",\"name\":\"n1\"}]");
            
        assertEquals(jsonObj, app.getObject(app.getJSONArray, "name"));
    } 

    @Test
    public void testNameOrSurname() {
        assertEquals("sn1", app.getNameOrSurname(app.getJSONObject(), "name"));
    }



    /*
    @Test
    public void testSum1() {
        System.out.println("Test");
        assertEquals(50, com.app.App.sum(20,30));
    }

    @After
    public void testSum2() {
        System.out.println("After");
    }

    @Before
    public void testSum3() {
        System.out.println("Before");
    }
    @BeforeClass
    public static void testSum4() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void testSum5() {
        System.out.println("After Class");
    }
    */
}
