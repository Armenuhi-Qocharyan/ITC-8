package com.itc;
import org.testng.annotations.*;

public class AppTest 

{
    @Test
    public void hello() {}
    @BeforeSuite
    public void beforeSuite() {
       System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
       System.out.println("AfterSuite");
    } 

    @BeforeTest
    public void beforeTest() {
       System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterTest() {
       System.out.println("AfterTest");
    } 


    @BeforeClass
    public static void setUpClass() throws Exception {
	System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
	System.out.println("AfterClass");
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
	System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
	System.out.println("AfterMethod");
    }
   
    @Parameters({ "string" })
    @Test
    public void funcWithParam(String param) {
	System.out.println("param - " + param);
    }

}
