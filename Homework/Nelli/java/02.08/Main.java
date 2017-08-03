import solder.Solder;
import board.Field;
public class Main {
    public static void main(String[] args) {
        Field board = new Field();
        board.AddSoldersFromFile("solder.txt");
    }
}