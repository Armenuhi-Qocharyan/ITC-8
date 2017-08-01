import Billiard.Table;
import Billiard.Ball;
import java.util.ArrayList;
import java.lang.InterruptedException;

public class Main {

    public static void main(String[] args) {
        Table table = new Table(200, 200);
        table.createBalls(14, 3, 0.15f);
        table.getBalls().get(0).setVector(5, 5);
        table.startGame(100000);

        System.out.print("--------END GAME-------");

    }
}
