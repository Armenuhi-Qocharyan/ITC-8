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
        testCustomException test = new testCustomException();
        try {
            test.devideCompileTime(10, 0);
        } catch (compileTimeException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            test.devideRunTime();
        } catch (runTimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
