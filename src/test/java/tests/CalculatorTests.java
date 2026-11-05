package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import helpers.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Калькулятор: арифметика")
public class CalculatorTests {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Сложение двух чисел")
    void addTest() {
        assertEquals(5, calculator.add(2, 3));
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({"10, 2, 5", "9, 3, 3", "7, 7, 1"})
    @DisplayName("Деление нацело")
    void divideTest(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b));
    }

    @Test
    @DisplayName("Деление на ноль выбрасывает исключение")
    void divideByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}
