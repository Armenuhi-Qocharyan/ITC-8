package decoratordesignpattern;

/**
 * This class illustrates Decorator design pattern usage
 * @author mary
 */
public class DecoratorDesignPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Syracuse syracuse = new Syracuse();
        System.out.println("Syracuse base pizza price: " + syracuse.getPrice() + " $");
        
        Cheese cheeseSyracuse = new Cheese(syracuse);
        System.out.println("Syracuse with cheese topping: " + cheeseSyracuse.getPrice() + " $");
        
        Mushroom mushroomCheeseSyracuse = new Mushroom(cheeseSyracuse);
        System.out.println("Syracuse with cheese and mushroom toppings: " + mushroomCheeseSyracuse.getPrice() + " $");
        
        Assorti assorti = new Assorti();
        System.out.println("Assorti base pizza price: " + assorti.getPrice() + " $");
        
        Majorio majorioAssorti = new Majorio(assorti);
        System.out.println("Assorti with majorio sauce: " + majorioAssorti.getPrice() + " $");
    }
}
