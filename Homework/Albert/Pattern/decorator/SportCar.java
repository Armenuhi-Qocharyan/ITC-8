public class SportCar extends CarDecorator {
    public SportCar(Car car) {
        super(car);
    }

    @Override
    public void assembleCar() {
        super.assembleCar();
        System.out.println("Adding features of Sports Car ");
    }
}
