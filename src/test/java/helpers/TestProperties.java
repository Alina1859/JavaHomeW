package helpers;

import org.junit.jupiter.api.Test;

public class TestProperties {

    @Test
    void propertyBaseUrlTest() {
        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");

        System.out.println("Base URL is: " + baseUrl);
    }

    @Test
    void propertyRemoteTest() {
        String remote = System.getProperty("remote", "https://user1:1234@selenoid.qa.guru/wd/hub");

        System.out.println("Remote browser URL is: " + remote);
    }

    @Test
    void propertyBrowserTest() {
        String browser = System.getProperty("browser", "chrome");

        System.out.println("Browser is: " + browser);
    }

    @Test
    void propertyBrowserVersionTest() {
        String browserVersion = System.getProperty("browserVersion", "157.0");

        System.out.println("Browser version is: " + browserVersion);
    }

    @Test
    void propertyHeadlessTest() {
        String headless = System.getProperty("headless", "false");

        System.out.println("Headless is: " + headless);
    }

    @Test
    void propertyBrowserSizeTest() {
        String browserSize = System.getProperty("browserSize", "1920x1080");

        System.out.println("Browser size is: " + browserSize);
    }
}
