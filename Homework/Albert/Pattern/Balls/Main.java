import Balls.*;

public class Main {
    public static void main(String[] args) {
        
        Board board = Board.getInstance(500, 500); // height, wigth

        BallInterface firstBall = new IronBall(new Ball(0, 0,5,4,90)); //x, y, r, v, angle
        BallInterface secondBall = new IronBall(new Ball(20,0,5,4,270)); // x, y, r, v, angle
        BallInterface thirdBall = new TitanBall(new Ball(50,0,5,4,270)); // x, y, r, v, angle

        board.setBall(firstBall);
        board.setBall(secondBall);
        board.setBall(thirdBall);
        
        firstBall.addObserver(board);
        board.start(150); // time

        /* Visitor pattern
        IronBall firstBall = new IronBall(new Ball(0, 0,5,4,90));
        BallVisitor iron = new CheckBoundVisitor();
        iron.visit(firstBall);
        */
    }
}

