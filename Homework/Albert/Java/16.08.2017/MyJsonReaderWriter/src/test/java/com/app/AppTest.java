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
import org.json.simple.JSONArray;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * Unit test for simple App.
 */

//extends TestCase 
public class AppTest {

    App app;
    JSONObject obj = new JSONObject();

    @Before
    public void init() {
        //System.out.println("Before");
        app = new App();
        obj = new JSONObject();
        obj.put("name","n1");
        obj.put("surname","sn1");
        JSONArray homeworks = new JSONArray();
        homeworks.add("h1");
        homeworks.add("h2");
        homeworks.add("h3");
        obj.put("homeworks", homeworks);
    }

    @Test
    public void testGetObject() {
        //JSONObject jsonObj = new JSONObject("[{\"homeworks\":[\"h1\",\"h2\",\"h3\"],\"surname\":\"sn1\",\"name\":\"n1\"}]");
        try {
            assertEquals(obj, app.getObject(app.getJSONArray(), "n1"));
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }
    } 

    @Test
    public void testGetNameOrSurname() {
        assertEquals("n1", app.getNameOrSurname(obj,"name"));
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
