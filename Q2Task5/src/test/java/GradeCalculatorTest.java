import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GradeCalculatorTest {

    // Method source for parameterized test
    static Stream<Arguments> gradeProvider() {
        return Stream.of(
                Arguments.of(95, "A"),
                Arguments.of(85, "B"),
                Arguments.of(75, "C"),
                Arguments.of(65, "D"),
                Arguments.of(55, "F")
        );
    }

    @ParameterizedTest
    @MethodSource("gradeProvider")
    void testGetGrade(int score, String expectedGrade) {
        assertEquals(expectedGrade, GradeCalculator.getGrade(score),
                "Grade should match the expected value");
    }

    @Test
    void testGetGradeWithInvalidScore() {
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(-1));
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(101));
    }
}
