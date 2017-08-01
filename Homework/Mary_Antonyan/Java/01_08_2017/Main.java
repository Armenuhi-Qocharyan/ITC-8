public class Main {
    public static void main(String[] args) {
        Ball first = new Ball(1, 2, 1, 2, 1, 0);
        Ball second = new Ball(10, 2, 1, 2, -1, 0);

        first.getStatus(second, 10);
    }
}
