public class Calculator {

    public int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }
    public int add(int a, int b) {
        return a + b;
    }



    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public void simulateLongTask() {
        try {
            Thread.sleep(200); // Simulate a long task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

//Question 1 - 7 java class