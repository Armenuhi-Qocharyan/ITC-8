package com.itc;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.*;

public class AppTest 

{
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
	System.out.println("BeforeClass\n");
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
	System.out.println("AfterMethod\n");
    }
   
    @Parameters({ "string"})
    @Test
    public void funcWithParam(String param) {
	System.out.println("param - " + param);
    }
    
    @Test(enabled = true)
    public void enabledTest(){
        System.out.println("Test is enabled");
    }

    @Test(timeOut = 10000)
    public void TimeoutTest(){
        System.out.println("Test with timeout");
    }
    
    @Test(priority = 1)
    public void hightPriorityTest() {
        System.out.println("Test with hight priority");
    }

    @Test(priority = 100)
    public void lowPriorityTest() {
        System.out.println("Test with low priority");
    }
    
    @Test(dependsOnMethods = "lowPriorityTest")
    public void testWithDepends() {
             System.out.println("Test with depends");
    }
    
    @Test(groups = "group1")
    public void groupTest1(){
        System.out.println("group 1 test");
        assertTrue(true);
    }

    @Test(groups = "group1")
    public void groupTest2(){
        System.out.println("group 1 test");
        assertTrue(true);
    }
    
    @Test(dependsOnGroups = "group1")
    public void groupDependsTest() {
        System.out.println("Group depends test");
    }
}
