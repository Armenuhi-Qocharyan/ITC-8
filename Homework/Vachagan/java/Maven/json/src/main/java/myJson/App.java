package myJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class App
{
    public static void main(String args[])
    {
        JSONObject obj = getJsonObj(args[0], args[1]);
        if(obj != null) {
             ArrayList<String> list = Print(obj,args[1]);
             System.out.println(list);
        }
    }
    
    public static JSONObject getJsonObj(String path, String name) {
        
        JSONParser parser = new JSONParser();

        try
        {
            Object object = parser.parse(new FileReader("./test.json"));
            JSONArray jsonArray = (JSONArray) object;
            for (Object obj : jsonArray) {
                JSONObject jsonObj = (JSONObject) obj;
                if(jsonObj.get("Name").equals(name)) {
                    System.out.println(jsonObj);
                    return  jsonObj;
                }
            }
        }
        catch(FileNotFoundException fe) {
            fe.printStackTrace();
            return null;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public static  ArrayList<String> Print(JSONObject obj, String name) {
        if(obj.get("Name").equals(name)) {
            Object object = obj.get("Countries");
            return (ArrayList) object;
        } 
        return null;   
    }      

}
