
import shapes.*;   
import myprint.*;

import java.io.*;
public class Main {

    public static void func(String str,boolean pr) {

        Print myprint = new Print();
        
        if ( str.equalsIgnoreCase("point")) {
            Point p = new Point();
            p.Drow(myprint.PrintInFile(pr), '*');
        }
        if ( str.equalsIgnoreCase("line")) {
            Line l = new Line(25);
            l.Drow(myprint.PrintInFile(pr), '*');
        }
        if ( str.equalsIgnoreCase("rectangle")) {
            Rectangle r = new Rectangle(25, 40);
            r.Drow(myprint.PrintInFile(pr), '*');
        };
    }
    public static void main(String args[]){
        if(args[1].equalsIgnoreCase("file")){
            func(args[0],true);
        } else {
            func(args[0],false);
        }
    }
}