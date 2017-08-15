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

public class App {

    public static void main(String[] args) {
        reader();
    }

    public static void reader () {
         JSONParser parser = new JSONParser();

        try {

           Object obj = parser.parse(new FileReader("./data.json"));
           JSONArray jArray = (JSONArray) obj;
                    
           Iterator<JSONObject> iterator = jArray.iterator();
            while (iterator.hasNext()) {
                JSONObject a = iterator.next();
                String name = (String) a.get("name");
                if (name.equals("aa")) {
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
                }
            }
            
           writer(jArray);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Can't read file");
        } catch (ParseException e) {
            System.out.println("Can't parse json");
        }

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
}
