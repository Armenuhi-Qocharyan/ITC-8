public class Main {
    public static void main(String[] args) {
        try {
            runTime();
        }
        catch(RunTimeException ex) {
            //System.out.println("Word contains number 0!!!");
            ex.printStackTrace();
        }
        try {
            compileTime();
        }
        catch(CompileTimeException ex) {
            //System.out.println("Word contains one or more spaces!!!");
            ex.printStackTrace();
        }
    }
    public static void compileTime() throws CompileTimeException {
        String word = "aaa aaa";
        if(word.contains(" ")) {
            //System.out.println("throws compile time exception.");
            throw new CompileTimeException("Word contains one or more spaces");
        }
    }
    public static void runTime() {
    String word = "a1b2c35550";
        if(word.contains("0")) {
            //System.out.println("throws run time exception.");
            throw new RunTimeException("Word contains number 0");
        }
    }
}
