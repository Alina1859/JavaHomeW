package helpers;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    @BeforeAll
    static void setUpAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--no-sandbox", "--disable-dev-shm-usage");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
