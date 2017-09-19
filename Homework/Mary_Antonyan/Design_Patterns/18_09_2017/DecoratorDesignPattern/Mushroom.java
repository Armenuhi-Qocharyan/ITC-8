package decoratordesignpattern;

/**
 * This class illustrates mushroom topping
 * @author mary
 */
public class Mushroom extends Topping {
    
    public Mushroom(Pizza pizza) {
        super(pizza, 2.1);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + this.price;
    }
}
