public class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assembleCar(){
        super.assembleCar();
        System.out.print("Adding features of Luxury Car ");
    }
}
