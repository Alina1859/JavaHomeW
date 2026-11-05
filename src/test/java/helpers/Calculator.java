package helpers;

import io.qameta.allure.Step;

public class Calculator {

    @Step("Сложить {a} и {b}")
    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}
