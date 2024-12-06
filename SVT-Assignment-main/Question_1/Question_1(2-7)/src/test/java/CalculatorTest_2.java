import org.junit.jupiter.api.*;
import java.util.List;
import java.time.Duration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest_2 {

    Calculator calculator;

    @BeforeEach
    void setUp() {

        calculator = new Calculator();
    }

    @Test
    void testArrayEquality() {
        // Example arrays for testing
        int[] expected = {1, 2, 3,4};
        int[] actual = {1, 2, 3,4};

        // Verify both arrays are identical
        assertArrayEquals(expected, actual, "Arrays should be identical");
    }

    @Test
    void testObjectInstance() {
        // Create another reference to the same calculator instance
        Calculator sameCalculator = calculator;

        // Ensure both references point to the same object
        assertSame(calculator, sameCalculator, "Both references should refer to the same instance");
    }

    @Test
    void testMultiLineStringContent() {
        // Example multi-line strings
        String expected = """
                Line 1
                Line 2
                Line 3
                """;

        String actual = """
                Line 1
                Line 2
                Line 3
                """;

        // Convert strings into lists for comparison
        List<String> expectedLines = List.of(expected.split("\n"));
        List<String> actualLines = List.of(actual.split("\n"));

        // Validate multi-line string content
        assertLinesMatch(expectedLines, actualLines, "Multi-line strings should match line by line");
    }

    @Test
    void testMethodCompletesWithinTimeLimit() {
        // Validate the method completes within 300ms
        assertTimeout(Duration.ofMillis(300), () -> calculator.longRunningOperation(),
                "The method should complete within 300 milliseconds");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "10, -5, 5",
            "0, 0, 0",
            "-3, -7, -10"
    })
    void testAdd(int a, int b, int expected) {
        // Verify that the add method returns the correct sum
        assertEquals(expected, calculator.add(a, b),
                () -> String.format("add(%d, %d) should return %d", a, b, expected));
    }

//    Question one task 7
    @RepeatedTest(5) // Repeats the test 5 times
    void testGenerateRandomNumberWithinRange() {
        int min = 1;  // Minimum value for the range (inclusive)
        int max = 10; // Maximum value for the range (exclusive)
        int result = calculator.generateRandomNumber(min, max);

        // Verify the generated number is within the specified range
        assertTrue(result >= min && result < max,
                () -> String.format("Generated number %d is not within range [%d, %d)", result, min, max));
    }
}
