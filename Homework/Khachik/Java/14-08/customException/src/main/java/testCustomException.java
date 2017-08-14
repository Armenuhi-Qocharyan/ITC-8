
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xacho
 */
public class testCustomException {
    public void devideCompileTime (int arg1, int arg2) throws compileTimeException {
        if (arg2 == 0) {
           throw new compileTimeException("Devide by 0");
        }
        System.out.append(arg1 + " / " + arg2 + " = " + arg1 / arg2);
    }
    
    
    public void devideRunTime () {
        Scanner scan = new Scanner(System.in);
        System.out.append("firstArgument = ");
        int arg1 = scan.nextInt();
        System.out.append("secondArgument = ");
        int arg2 = scan.nextInt();
        if (arg2 == 0) {
           throw new runTimeException("Devide by 0");
        }
        System.out.append(arg1 + " / " + arg2 + " = " + arg1 / arg2);
    }
}
