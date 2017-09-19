package decoratordesignpattern;

/**
 * This class illustrates the base pizza
 * @author mary
 */
public class Pizza {
    protected double price;

    /**
     * 
     * @param price base pizza price
     */
    public Pizza(double price) {
        setPrice(price);
    }

    /**
     * Gets base pizza price
     * @return base pizza price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set base pizza price
     * @param price base pizza price
     */
    public void setPrice(double price) {
        this.price = (price > 0) ? price : 1;
    }   
}