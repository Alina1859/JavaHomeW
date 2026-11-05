package helpers;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUpAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
