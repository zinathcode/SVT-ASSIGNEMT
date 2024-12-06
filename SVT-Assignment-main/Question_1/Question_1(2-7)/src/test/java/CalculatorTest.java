import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        System.out.println("Addition work");
        assertEquals(5, calculator.add(2, 3), "Addition should return 5");
        assertNotEquals(6, calculator.add(2, 3), "Addition should not return 6");
    }

    @Test
    void testDivide() {

        assertEquals(2, calculator.divide(6, 3), "Division should return 2");

        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0),"Division by zero should throw an ArithmeticException");
        // assertNull(calculator.divide(6, 0), "Division by zero should return null");
        calculator.divide(6, 3);
    }

    @Test
    void testDivideDoesNotThrow() {

        assertDoesNotThrow(() -> calculator.divide(10, 2),
                "Division with non-zero denominator should not throw an exception");
    }

    @Test
    void testLogicalAssertions() {
        // Check logical assertions for add and divide
        assertTrue(calculator.add(1, 1) == 2, "Addition result should be true");
        assertFalse(calculator.add(1, 1) == 3, "Addition result should be false");

        // Check division logic
        assertTrue(calculator.divide(10, 2) == 5, "Division result should be true");
        assertFalse(calculator.divide(10, 2) == 6, "Division result should be false");
    }
}
