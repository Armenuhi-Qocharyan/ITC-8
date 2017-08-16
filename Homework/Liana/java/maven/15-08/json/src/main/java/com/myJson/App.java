package com.myJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


public class App {

    public static void main(String[] args)  {
        System.out.print("Enter file path: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        System.out.print("Enter name to get object: ");
        String name = sc.next();
        JSONObject myobj = reader(path, name);
        if(myobj != null) {
            Object res = print(myobj, "homeworks");
            System.out.println(res);
        }
      //  Object res = print(myobj, "name");
    }

    public static JSONObject reader (String path, String anun)  {
         JSONParser parser = new JSONParser();

        try {

           Object obj = parser.parse(new FileReader(path));
           JSONArray jArray = (JSONArray) obj;
                    
           Iterator<JSONObject> iterator = jArray.iterator();
            while (iterator.hasNext()) {
                JSONObject a = iterator.next();
                String name = (String) a.get("name");
                if (name.equals(anun)) {
                    return a;
                    /*
                    System.out.print("name: " + name + ",\t");
                    String surname = (String) a.get("surname");
                    System.out.print("surname: " + surname + ",\t");
                    JSONArray homework = (JSONArray) a.get("homeworks");
                    Iterator<String> iterator1 = homework.iterator();
                    System.out.print("Homeworks: ");
                    while (iterator1.hasNext()) {
                        System.out.print(iterator1.next() + ", ");
                    }

                    System.out.println();
                     */
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        } catch (IOException e) {
            System.out.println("Can't read file");
            return null;
        } catch (ParseException e) {
            System.out.println("Can't parse json");
            return null;
        }
        return null;

    }

    public static void writer (JSONArray array) {
        JSONObject newObj = new JSONObject();
        newObj.put("name", "newName");
        newObj.put("surname", "newSurname");
        JSONArray homeworks = new JSONArray();
        homeworks.add("newH1");
        homeworks.add("newH2");
        homeworks.add("newH3");
        newObj.put("homeworks", homeworks);
        array.add(newObj);
        try {
            File file=new File("./data.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("Writing JSON object to file");
            fileWriter.write(array.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Can't write in file");
        }
    }
    
    public static Object print(JSONObject obj, String type) {
           return obj.get(type);
       
    }
}
