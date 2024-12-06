import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Initializing resources before all tests...");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up resources after each test...");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Cleaning up resources after all tests...");
    }

    @Test
    void testAddUsingAssertions() {
        assertEquals(10, calculator.add(5, 5), "Addition should return 10");
        assertNotEquals(11, calculator.add(5, 5), "Addition should not return 11");
        assertNotNull(calculator.add(3, 4), "Addition result should not be null");
        assertTrue(calculator.add(2, 2) == 4, "2 + 2 should be 4");
        assertFalse(calculator.add(2, 2) == 5, "2 + 2 should not be 5");
    }

    @Test
    void testDivisionByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(10, 0),
                "Division by zero should throw IllegalArgumentException");

        assertDoesNotThrow(() -> calculator.divide(10, 2),
                "Division with non-zero denominator should not throw an exception");
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(500), () -> {
            calculator.divide(10, 2);
        }, "The method should complete within the given time limit");


        assertTimeout(Duration.ofMillis(250), () -> {
            calculator.simulateLongTask();
        }, "The method should complete within the time limit");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "5, 5, 10",
            "-1, -1, -2"
    })
    void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b), "Addition should return the expected result");
    }

    @RepeatedTest(5)
    void testGenerateRandomNumberWithinRange() {
        int result = calculator.generateRandomNumber();
        assertTrue(result >= 0 && result < 10, "Random number should be between 0 and 9");
    }
}

//Question 1-7