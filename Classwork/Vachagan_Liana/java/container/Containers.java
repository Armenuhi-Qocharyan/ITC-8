import java.util.ArrayList;

public class Containers {
        public static ArrayList<Integer> Sum (ArrayList<Integer> first,ArrayList<Integer> last, char sign) {
                
                int size = Math.max(first.size(),last.size());

                ArrayList<Integer> result = new ArrayList<Integer>();          
                
                for (int i = 0 ;i < size; ++i) {
                        if(first.size() <= i){
                                result.add(last.get(i));
                        } else if (last.size() <= i) {
                               result.add(first.get(i));
                        } else {
                                switch (sign) {
                                        case '+':
                                           result.add(first.get(i) + last.get(i));
                                           break;
                                        case '*':
                                           result.add(first.get(i) * last.get(i));
                                           break; 
                                        case '-':
                                           result.add(first.get(i) - last.get(i));
                                           break;
                                        case '/':
                                           result.add(first.get(i) / last.get(i));
                                           break;                                                 
                                }
                        }
                }

                return result; 
        }
} 