/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author student
 */
public class MainTest {
    
    public MainTest() {
    }
    
    /**
     * Test of getObject method, of class Main.
     */
    
    @Test
    public void testGetObject() {
        System.out.println("getObject");
        JSONParser parser = new JSONParser();
        JSONArray studentList = null;
        try {
            studentList = (JSONArray) parser.parse("[{\"homeworks\":[\"angular\",\"node js\",\"java\",\"maven\"],\"name\":\"Khachik\",\"surename\":\"Ghazaryan\"},{\"homeworks\":[\"nodejs\",\"angular\",\"maven\"],\"name\":\"name1\",\"surename\":\"surename1\"},{\"homeworks\":[\"kerparvest\",\"par\",\"barba\",\"xar@ kriv\"],\"name\":\"Nelli\",\"surename\":\"Melkonyan\"}]");
        } catch (ParseException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(Main.getObject(studentList, "wrongName"), null);
        JSONObject obj = null;
        try {
            obj = (JSONObject)parser.parse("{\"homeworks\":[\"angular\",\"node js\",\"java\",\"maven\"],\"name\":\"Khachik\",\"surename\":\"Ghazaryan\"}");
            assertEquals(Main.getObject(studentList, "Khachik"), obj);
        } catch (ParseException ex) {
            System.out.println("Test error");
        }
        
    }

    /**
     * Test of getObjValue method, of class Main.
     */
    @Test
    public void testGetObjValue() {
        System.out.println("getObjValue");
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject)parser.parse("{\"homeworks\":[\"angular\",\"node js\",\"java\",\"maven\"],\"name\":\"Khachik\",\"surename\":\"Ghazaryan\"}");
        } catch (ParseException ex) {
            System.out.println("Test error");
        }
        assertEquals(Main.getObjValue(obj, "wrongName"),null);
    }

}
