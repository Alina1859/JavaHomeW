package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Строки")
@DisplayName("Строки: базовые операции")
public class StringTests {

    @Test
    @DisplayName("Строка приводится к верхнему регистру")
    void upperCaseTest() {
        assertEquals("ALLURE", toUpper("allure"));
    }

    @Test
    @DisplayName("Строка содержит подстроку")
    void containsTest() {
        assertTrue("Hello, Allure!".contains("Allure"));
    }

    @Step("Привести {value} к верхнему регистру")
    private String toUpper(String value) {
        return value.toUpperCase();
    }
}
