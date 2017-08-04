public class Main {

    public static void main(String[] args) {
        Army first = new Army("Turkey");
        Army second = new Army("Azerbaijan");
        first.initSoldiers("first_army.txt");
        second.initSoldiers("second_army.txt");
        Area area = new Area ();
        area.start(first, second);
        area.start(second, first);
    }
}
