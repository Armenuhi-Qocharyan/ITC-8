import solder.Solder;
import board.Field;
public class Main {
    public static void main(String[] args) {
        Field board = new Field(100);
        board.AddSoldersFromFile("solder.txt");
        board.printSoldersInfo();
        board.war();
    }
}
