import shape.ScrollDecorator;
import shape.BorderDecorator;
import shape.View;
import shape.Shape;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        Shape scrollView = new ScrollDecorator(view);    
        Shape borderView = new BorderDecorator(view);
        Shape borderScrollView = new BorderDecorator(scrollView);

        view.draw();
        scrollView.draw();
        borderView.draw();
        borderScrollView.draw();
           
        System.out.println("\n----------------------------------------");        
    }
}
