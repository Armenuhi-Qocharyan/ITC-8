package decoratordesignpattern;

/**
 * This class illustrates the topping of pizza
 * @author mary
 */
public class Topping extends Pizza {
    protected final Pizza pizza;

    /**
     * 
     * @param pizza base pizza
     * @param price topping price
     */
    public Topping(Pizza pizza, double price) {
        super(price);
        this.pizza = pizza;
    }
}
