package com.itc.parser;

import java.util.ArrayList;

/**
 * This class represents the student objects
 * 
 * @author mary
 */
public class Student {
    private String name;
    private String surname;
    private ArrayList<String> homeworks;

    /**
     * Creates student object
     * 
     * @param name student name
     * @param surname student surname
     * @param homeworks student homework list
     */
    public Student(String name, String surname, ArrayList<String> homeworks) {
        this.name = name;
        this.surname = surname;
        this.homeworks = homeworks;
    }

    /**
     * 
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name student name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return student surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * 
     * @param surname student surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * 
     * @return list of homework
     */
    public ArrayList<String> getHomeworks() {
        return homeworks;
    }

    /**
     * 
     * @param homeworks list of homework
     */
    public void setHomeworks(ArrayList<String> homeworks) {
        this.homeworks = homeworks;
    }   
    
    /**
     * Print information about student
     */
    public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.print("Homeworks: " + homeworks.toString());
    }
}