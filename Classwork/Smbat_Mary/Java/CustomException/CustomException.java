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
public class CustomException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            a();
        } catch (MyException e){
            System.out.println(e);
        }
        
        a();
    }
    
    public static void a() throws MyException {
        throw new MyException("Exceeeeepppppttiiion");
    }
    
}
