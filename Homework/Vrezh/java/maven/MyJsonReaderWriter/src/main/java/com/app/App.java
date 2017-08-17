package com.app;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class App 
{
    public static void main( String[] args )
    {
        try {
            JSONParser parser = new JSONParser();
            JSONArray users = (JSONArray) parser.parse(new FileReader("data.json"));
            JSONObject user = getObject(users,"n1");
            getNameOrSurname(user, "name");

            System.out.println(user);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }
    }
    
    public static JSONObject getObject(JSONArray array, String name) {
        for (Object object:array ) {
            if (((JSONObject)(object)).get("name").equals( name)) {
                return (JSONObject)object;
            }
        }
        return null;
    }

    public static JSONArray getJSONArray() {
         try {
            JSONParser parser = new JSONParser();
            JSONArray users = (JSONArray) parser.parse(new FileReader("data.json"));
            return users;
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }   
        return null;    
    }


    public static void getNameOrSurname(JSONObject object, String nameOrSurname) {
        System.out.println(object.get(nameOrSurname));
    }

    public static int sum(int a, int b) {
        return a+b;
    }
    public static int sub(int a, int b) {
        return a-b;
    }


}
