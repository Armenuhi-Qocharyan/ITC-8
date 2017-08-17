package com.itc;

import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */

public class AppTest  {

    @Test
    public void testMyTest() {
        System.out.println(" first test ");
    }
    @BeforeMethod
    public void testBefore() {
        System.out.println(" before method ");
    }
    @Test
    public void testMyTest1() {
        System.out.println(" test1 group1 ");
    }
    @Test
    public void testMyTest2() {
        System.out.println(" test2 group2 ");
    }
    @Test
    public void testMyTest3() {
        System.out.println(" test3 group1 ");
    }
    @BeforeClass
    public void testBeforeClass() {
        System.out.println(" before class ");
    }




}
