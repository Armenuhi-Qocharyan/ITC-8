package Balls;

public class CheckBoundVisitor implements BallVisitor {
    @Override
    public void visit(IronBall ironBall) {
        System.out.println("IronBall visit\n");
    }

    @Override
    public void visit(TitanBall titanBall) {
        System.out.println("TitanBall visit\n");
    }
}
