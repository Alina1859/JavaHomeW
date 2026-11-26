package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class TestBase {

    private static final String STAGE_REMOTE = "https://user1:1234@selenoid.qa.guru/wd/hub";

    @BeforeAll
    static void setUpAll() {
        String env = System.getProperty("ENV", "local");

        Configuration.baseUrl = System.getProperty("baseUrl", "https://kvality.io");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 15000;

        switch (env) {
            case "local" -> {
                Configuration.remote = null;
                Configuration.browserVersion = "";
            }
            case "stage", "prod" -> {
                Configuration.remote = System.getProperty("remote", STAGE_REMOTE);
                Configuration.browserVersion = System.getProperty("browserVersion", "157.0");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox");
                chromeOptions.setCapability("se:cdpEnabled", false);
                chromeOptions.setCapability("selenoid:options", Map.of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
                Configuration.browserCapabilities = chromeOptions;
            }
            default -> throw new IllegalArgumentException(
                    "ENV должен быть 'local', 'stage' или 'prod', а получено: " + env);
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterEach
    void addAttachments() {
        if (hasWebDriverStarted()) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            if (Configuration.remote != null) {
                Attach.addVideo();
            }
        }
        closeWebDriver();
    }
}
