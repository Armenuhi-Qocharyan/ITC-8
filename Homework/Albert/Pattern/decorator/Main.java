public class Main {
    public static void main(String[] args) {
        Car sportCar = new SportCar(new BasicCar());
        sportCar.assembleCar();
        Car sportLuxuryCar = new SportCar(new LuxuryCar(new BasicCar()));
        sportLuxuryCar.assembleCar();
    }
}
