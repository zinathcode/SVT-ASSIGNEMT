package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureConverterTest {

    @ParameterizedTest
    @MethodSource("provideCelsiusToFahrenheitData")
    void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {
        // Act
        double result = TemperatureConverter.celsiusToFahrenheit(celsius);

        // Assert
        assertEquals(expectedFahrenheit, result, 0.001, "Fahrenheit value mismatch");
    }

    private static Stream<Arguments> provideCelsiusToFahrenheitData() {
        return Stream.of(
                Arguments.of(0.0, 32.0),
                Arguments.of(25.0, 77.0),
                Arguments.of(-40.0, -40.0)
        );
    }
}
