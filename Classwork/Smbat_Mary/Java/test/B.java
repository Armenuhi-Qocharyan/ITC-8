/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author student
 */
public class B {
    // Members
    private String name;
    private String surname;
    private int age;
    
    // Constructors
    public B(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    
    public B(String name, String surname, int age) {
        this(name, surname);
        this.age = age;
    }
    
    // Method
    public void print() {
        System.out.println(name + " " + surname + " " + age);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}