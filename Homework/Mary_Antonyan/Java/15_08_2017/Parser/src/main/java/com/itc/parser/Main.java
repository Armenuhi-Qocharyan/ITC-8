package com.itc.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mary
 */
public class Main {
    /**
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Parser parser = new Parser("info.json");
        try {
            parser.write();
        } catch (IOException ex) { 
            System.out.println("Exception thrown from write(): " + ex.getMessage());
        }
        
        try {
            ArrayList<Student> students = parser.read();
            for (Student student : students) {
                student.print();
            }
        } catch (FileNotFoundException | ParseException ex) {
            System.out.println("Exception thrown from read(): " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Exception thrown from read(): " + ex.getMessage());
        } 
    }   
}