package helpers;

import org.junit.jupiter.api.Test;

public class TestProperties {

    public static final String baseUrl =
            System.getProperty("baseUrl", "https://demoqa.com");
    public static final String remote =
            System.getProperty("remote", "https://user1:1234@selenoid.qa.guru/wd/hub");
    public static final String browser =
            System.getProperty("browser", "chrome");
    public static final String browserVersion =
            System.getProperty("browserVersion", "157.0");
    public static final boolean headless =
            Boolean.parseBoolean(System.getProperty("headless", "false"));
    public static final String browserSize =
            System.getProperty("browserSize", "1920x1080");

    @Test
    void propertyBaseUrlTest() {
        System.out.println("Base URL is: " + baseUrl);
    }

    @Test
    void propertyRemoteTest() {
        System.out.println("Remote browser URL is: " + remote);
    }

    @Test
    void propertyBrowserTest() {
        System.out.println("Browser is: " + browser);
    }

    @Test
    void propertyBrowserVersionTest() {
        System.out.println("Browser version is: " + browserVersion);
    }

    @Test
    void propertyHeadlessTest() {
        System.out.println("Headless is: " + headless);
    }

    @Test
    void propertyBrowserSizeTest() {
        System.out.println("Browser size is: " + browserSize);
    }
}
