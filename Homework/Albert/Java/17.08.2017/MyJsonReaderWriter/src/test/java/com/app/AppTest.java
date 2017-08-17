package com.app;

//import org.junit.Test;
//import org.junit.TestCase;
//import org.junit.TestSuite;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//import java.io.IOException;
//import org.json.simple.parser.ParseException;
import static org.junit.Assert.*;
import org.testng.annotations.*;


public class AppTest {

    @Test(groups="group1")
    public void testSum1() {
        System.out.println("Test-1 Sum");
        assertEquals(50, com.app.App.sum(20,30));
    }

    @Test(groups="group2")
    public void testSum3() {
        System.out.println("Test-3 Sum");
        assertEquals(5, com.app.App.sum(2,3));
    }

    @Parameters({"name"})
    @Test
    public void testString(String firstName) {
        System.out.println("Invoked testString " + firstName);
        assert "John".equals(firstName);
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("@AfterGroups");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }
}

/*
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

*/
