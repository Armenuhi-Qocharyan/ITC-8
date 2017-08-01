import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                 ArrayList<Integer> obj = new ArrayList<Integer>();
                 ArrayList<Integer> obj1 = new ArrayList<Integer>();
               obj.add(0);         
               obj.add(1);         
               obj.add(2);         
               obj.add(3);

                        
               obj1.add(0);         
               obj1.add(3);         
               obj1.add(4);
               System.out.println(Containers.Sum(obj, obj1, '-'));         
               
        }
}