package com.app;

//import org.junit.Test;
//import org.junit.TestCase;
//import org.junit.TestSuite;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.json.simple.JSONObject;

import static org.junit.Assert.*;
import org.testng.annotations.*;

//extends TestCase 
public class AppTest {

    @Test(groups="group1")
    public void testSum1() {
        System.out.println("test 1   sum");
        assertEquals(50, com.app.App.sum(20,30));
    }
    @Test(groups="group2")
    public void testSum3() {
        System.out.println("test 3   sum");
        assertEquals(5, com.app.App.sum(2,3));
    }

    @Parameters({ "first-name1" })
    @Test
    public void testString(String firstName) {
        System.out.println("Invoked testString " + firstName);
        assert "Cedric".equals(firstName);
    }

}
