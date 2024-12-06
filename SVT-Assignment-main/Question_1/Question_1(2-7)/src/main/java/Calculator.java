import java.util.Random;
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }


    public void longRunningOperation() {
        try {
            Thread.sleep(200); // Simulate 200ms delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    //    Question one task 7
    private final Random random = new Random();

    public int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
