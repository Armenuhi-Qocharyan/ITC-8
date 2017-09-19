package decoratordesignpattern;

/**
 * This class illustrates cheese topping
 * @author mary
 */
public class Cheese extends Topping {
    public Cheese(Pizza pizza) {
        super(pizza, 1.5);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + this.price;
    }
}
