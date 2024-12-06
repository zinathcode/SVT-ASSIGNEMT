import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    @ParameterizedTest
    @DisplayName("Test Celsius to Fahrenheit conversion")
    @CsvSource({
            "0, 32",    // 0°C = 32°F
            "25, 77",   // 25°C = 77°F
            "-40, -40"  // -40°C = -40°F
    })
    void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {
        double result = TemperatureConverter.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, result, "The conversion did not match the expected value");
    }

    @Test
    @DisplayName("Test exception for temperature below absolute zero")
    void testCelsiusToFahrenheitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            TemperatureConverter.celsiusToFahrenheit(-274);
        }, "Expected IllegalArgumentException for temperature below absolute zero");
    }
}
