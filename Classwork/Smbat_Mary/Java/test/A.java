/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class A {
    // Member
    private int age;
    
    // Constructor
    public A(int age) {
        this.age = age;
    }
    
    // Methods
    public static void voice() {
        System.out.println("Voice A");
    }
    
    public void print() {
        System.out.println(age);
    }

    // Getter
    public int getAge() {
        return age;
    }

    // Setter
    public void setAge(int age) {
        this.age = age;
    }
    
}
