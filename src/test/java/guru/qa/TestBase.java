package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUpConfig() {
        Configuration.baseUrl = "https://www.saucedemo.com";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
