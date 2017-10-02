import Balls.*;

public class Main {
    public static void main(String[] args) {
        Board board = Board.getInstance(500, 500);

        BallInterface firstBall = new IronBall(new Ball(0, 0,5,4,90));
        BallInterface secondBall = new IronBall(new Ball(50,0,5,4,270));
        BallInterface thirdBall = new TitanBall(new Ball(30,0,5,4,270));

        board.setBall(firstBall);
        board.setBall(secondBall);
        board.setBall(thirdBall);

        firstBall.addObserver(board);

        board.start(150);
    }
}

