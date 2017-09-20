import Balls.*;

public class Main {
    public static void main(String[] args) {
        Board board = Board.getInstance(500, 500);
        Ball firstBall = new Ball(0, 0,5,2,90);
        Ball secondBall = new Ball(50,0,5,2,270);
        Ball thirdBall = new Ball(30,0,5,2,270);
        board.setBall(firstBall);
        board.setBall(secondBall);
        board.setBall(thirdBall);
        firstBall.addObserver(board);
        board.start(150);
    }
}

