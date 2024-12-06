package org.example;

class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        if (celsius < -273.15) throw new IllegalArgumentException("Temperature below absolute zero");
        return (celsius * 9 / 5) + 32;
    }
}
