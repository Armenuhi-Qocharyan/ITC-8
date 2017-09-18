package shape;

public class BorderDecorator implements Shape {
    private Shape shape;    

    public BorderDecorator(Shape shape) {
        this.shape = shape;
    }

    private void setBorder() {
        System.out.print(" Border");
    }

    @Override 
    public void draw() {
        this.shape.draw();
        setBorder();
    }
}

