package com.test;

import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testSum() {
        int res = App.sum(10, 7);
        assertEquals(17,res);
    }
    
    @Test
    public void testSum2() {
        int res = App.sum(10, 17);
        assertEquals(27,res);
    }


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Start testing");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Finish testing");
    }

    @Before
    public void beforeTest() {
        System.out.println("Start current test");
    }
    
    @After
    public void afterTest() {
        System.out.println("Finish current test");
    }
}
