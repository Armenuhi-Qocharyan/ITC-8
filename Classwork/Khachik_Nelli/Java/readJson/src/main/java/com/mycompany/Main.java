package com.mycompany;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xacho
 */
public class Main {
    
    public static void main(String[] args) {
        JSONArray studentList = connection();
        JSONObject obj = getObject(studentList, "Nelli");
        if (obj != null) {
            System.out.println(obj);
            Object val = getObjValue(obj, "popoq");
            if(val != null) {
                System.out.println(val);
            } else {
                System.out.println("Key not found");
            }
        } else {
            System.out.println("Object not found");
        }
        
        //setObject(jsonObject);
    }
    
    public static JSONArray connection() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        try {
            Object obj = parser.parse(new FileReader("MyJson.json"));
            jsonObject = (JSONObject) obj;
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
           ex.printStackTrace();
           return null;
        }
        JSONArray studentList = (JSONArray) jsonObject.get("studentList");
        return studentList;
    }
    /** 
     * 
     * @param jsonObject Json file
     * @param name Searching name 
     */
    public static JSONObject getObject ( JSONArray studentList, String name ) {
            for (int i = 0; i < studentList.size(); ++i) {
                JSONObject student = (JSONObject) studentList.get(i);
                if (student.get("name").equals(name)) {
                    return student;
                }
                    
            }
            return null;
    }
    
    public static Object getObjValue(JSONObject obj, String key) {
        return obj.get(key);
    }
    
    /**
     * 
     * @param jsonObject Changing object
     */ 
    public static void  setObject(JSONObject jsonObject) {
        Scanner scan = new Scanner(System.in);
        JSONObject obj = new JSONObject();
        System.out.print("Enter student name - ");
        String name = scan.nextLine();
        obj.put("name", name);
        System.out.print("Enter student surename - ");
        String surename = scan.nextLine();
        obj.put("surename", surename);
        
        System.out.println("Enter student homeworks:\nEnter null for end.");
        JSONArray list = new JSONArray();
        String homework;
        homework = scan.nextLine();
        while(!homework.equals("null")) {
            list.add(homework);
            homework = scan.nextLine();
        }
        obj.put("homeworks", list);
        JSONArray studentList = (JSONArray) jsonObject.get("studentList");
        studentList.add(obj);
        
        try(FileWriter file = new FileWriter("MyJson.json")) {
            jsonObject.clear();
            jsonObject.put("studentList", studentList);
            file.write(jsonObject.toString());
            file.flush();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(jsonObject.toString());
    }
}
