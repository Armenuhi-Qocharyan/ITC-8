package com.myJson;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
/**
 * Unit test for simple App.
 */
public class AppTest  {
    @Test
    public void testReader() {
        JSONObject object = new JSONObject();
        object.put("name","aa");
        object.put("surname","bb");
        JSONArray homeworks = new JSONArray();
        homeworks.add("h1");
        homeworks.add("h2");
        homeworks.add("h3");
        object.put("homeworks", homeworks);
        JSONObject myObject = App.reader("./data.json","aa");
        assertEquals(object, myObject);
    }
    @Test
    public void testPrint() {
        JSONObject object = new JSONObject();
        object.put("name","aa");
        object.put("surname","bb");
        JSONArray homeworks = new JSONArray();
        homeworks.add("h1");
        homeworks.add("h2");
        homeworks.add("h3");
        object.put("homeworks", homeworks);
        Object myObject = App.print(object,"name");
        String test = "aa";
        assertEquals("aa", myObject);
    }
}
