package Balls;

public class TitanBall extends BallDecorator {
    private float titanWeight = 4;

    public TitanBall(BallInterface ballInterface) {
        super(ballInterface);
    }
    @Override
    public void move(int i) {
        super.setWeight(this.titanWeight);
        super.move(i);

    }
    @Override
    public void printCoord(int i) {
        System.out.println("     type TitanBall     ");
        super.printCoord(i);
    }
    
    @Override
    public void accept(BallVisitor visitor) {
        visitor.visit(this);
    }
}
