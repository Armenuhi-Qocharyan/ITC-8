/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customexception;

/**
 *
 * @author student
 */
public class MyException extends RuntimeException {

    public MyException() {
    }

    public MyException(String string) {
        super(string);
    }   
}
