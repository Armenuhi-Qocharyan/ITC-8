package Balls;

public class IronBall extends BallDecorator {
    private float ironWeight = 2;

    public IronBall(BallInterface ballInterface) {
        super(ballInterface);
    }
    @Override
    public void move(int i) {
        super.setWeight(this.ironWeight);
        super.move(i);

    }

    @Override
       public void printCoord(int i) {
           System.out.print("     Type IronBall     ");
           super.printCoord(i);
       }

}
