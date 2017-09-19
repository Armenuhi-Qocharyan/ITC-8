package decoratordesignpattern;

/**
 * This class illustrates majorio sauce topping
 * @author mary
 */
public class Majorio extends Topping {
    public Majorio(Pizza pizza) {
        super(pizza, 1.5);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + this.price;
    }
}
