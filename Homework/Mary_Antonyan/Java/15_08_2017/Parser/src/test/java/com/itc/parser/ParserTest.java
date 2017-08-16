package com.itc.parser;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mary
 */
public class ParserTest {
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Started testing...");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished testing...");
    }
    
    @Before
    public void setUp() {
        System.out.print("Started testing class: ");
    }
    
    @After
    public void tearDown() {
        System.out.println("Finished testing class.");
    }

    /**
     * Test of getByName method, of class Parser.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void testGetByName() throws Exception {
        System.out.println("getByName");
        String studentName = "Mary";
        Parser instance = new Parser("info.json");
        
        ArrayList<Student> expResult = new ArrayList<>();
        ArrayList<String> hmws = new ArrayList<>();
        hmws.add("C++");
        hmws.add("Java");
        hmws.add("Maven");
        
        expResult.add(new Student("Mary", "Antonyan", hmws));
        ArrayList<Student> result = instance.getByName(studentName);
        for (int i = 0; i < result.size(); ++i) {
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertEquals(expResult.get(i).getSurname(), result.get(i).getSurname());
            assertEquals(expResult.get(i).getHomeworks(), result.get(i).getHomeworks());
        }
    }

    /**
     * Test of getByHomework method, of class Parser.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void testGetByHomework() throws Exception {
        System.out.println("getByHomework");
        ArrayList<String> studentHomeworks = new ArrayList<>();
        studentHomeworks.add("C++");
        studentHomeworks.add("Java");
        studentHomeworks.add("Python");
        
        Parser instance = new Parser("info.json");
        ArrayList<Student> expResult = new ArrayList<>();
        expResult.add(new Student("Liana", "Andreasyan", studentHomeworks));
        ArrayList<Student> result = instance.getByHomework(studentHomeworks);
        
        for (int i = 0; i < result.size(); ++i) {
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertEquals(expResult.get(i).getSurname(), result.get(i).getSurname());
            assertEquals(expResult.get(i).getHomeworks(), result.get(i).getHomeworks());
        }
    }   
}