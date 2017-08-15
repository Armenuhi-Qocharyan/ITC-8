package com.myJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("./data.json"));
        System.out.println(a);
        /*
        for (Object o : a)
        {
            JSONObject person = (JSONObject) o;
            
               String name = (String) person.get("name");
               System.out.println(name);

               String city = (String) person.get("city");
               System.out.println(city);

               String job = (String) person.get("job");
               System.out.println(job);

               JSONArray cars = (JSONArray) person.get("cars");

               for (Object c : cars)
               {
               System.out.println(a);
               }
        }*/
        }
}
