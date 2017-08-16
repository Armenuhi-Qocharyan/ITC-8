package com.newtest;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Before
    public void test() {
        System.out.println("********************");
    }
    
    @After
    public void tearDown() {
        System.out.println("---------------------");
    }
    
    @AfterClass
    public static void tearDownCl() {
         System.out.println(")))))))))))))))))");
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("=====================");
    }
    
    @Test
    public void testSum() {
        int sum = App.sum(5, 3);
        Assert.assertEquals(8, sum);
    }
    
    @Test
    public void testMin() {
        int min = App.min(5, 3);
        Assert.assertEquals(2, min);
    }

}
