package shape;

public class ScrollDecorator implements Shape {
    private Shape shape;    

    public ScrollDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override 
    public void draw() {
        this.shape.draw();
        setScroll();
    }

    private void setScroll() {
        System.out.print(" Scroll");
    }
    
}

