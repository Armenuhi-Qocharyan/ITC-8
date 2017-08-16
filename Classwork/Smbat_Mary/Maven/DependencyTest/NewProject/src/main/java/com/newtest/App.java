package com.newtest;
//import com.test.*;

/**
 * Hello world!
 *
 */
public class App  {
    public static void main( String[] args ) {
        System.out.println( " Hello World from com.newtest " );
	//com.test.App.myFunction();
	com.test.App.main(args);
    }

   public static int sum(int a, int b) {
	return a+b;
   }
   
   public static int min(int a, int b) {
	return a-b;
   }
}
