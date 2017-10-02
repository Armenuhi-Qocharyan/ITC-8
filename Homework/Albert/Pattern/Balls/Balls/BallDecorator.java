package Balls;

public class BallDecorator implements BallInterface {
    BallInterface ballInterface;

    public BallDecorator(BallInterface ballInterface) {
        this.ballInterface = ballInterface;
    }

    public void accept(BallVisitor visitor) { }

    @Override
    public float getWeight() {
        return ballInterface.getWeight();
    }
    @Override
    public void setWeight(float weight) {
        this.ballInterface.setWeight(weight);
    }

    @Override
    public int getX() {
        return ballInterface.getX();
    }
    @Override
    public void setX(int x) {
        this.ballInterface.setX(x);
    }

    @Override
    public int getY() {
        return ballInterface.getY();
    }
    @Override
    public void setY(int y) {
        this.ballInterface.setY(y);
    }

    @Override
    public int getR() {
        return ballInterface.getR();
    }

    @Override
    public void setR(int r) {
        this.ballInterface.setR(r);
    }

    @Override
    public void move(int i) {
        this.ballInterface.move(i);
    }

    @Override
    public double getDistance(BallInterface ball) {
        return this.ballInterface.getDistance(ball);
    }

    @Override
    public void addObserver(BallsCollisionObserver object) {
        this.ballInterface.addObserver(object);
    }

    @Override
    public void removeObserver(BallsCollisionObserver object) {
        this.ballInterface.removeObserver(object);
    }

    @Override
    public void checkCollisionTwoBalls(BallInterface ball) {
        this.ballInterface.checkCollisionTwoBalls(ball);
    }
    @Override
    public void printCoord(int i) {
        this.ballInterface.printCoord(i);
    }

    /*
       @Override
       public void checkCollisionBound(BallInterface ball) {
       this.ballInterface.checkCollisionBound(ball); 
       }
    */
}
