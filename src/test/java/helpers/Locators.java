package helpers;

public class Locators {

    public static final String SEARCH_BUTTON = "button[aria-label*='Search or jump to']";
    public static final String SEARCH_INPUT = "input[aria-label*='Search or jump to']";
    public static final String ISSUES_TAB = "[data-tab-item='issues']";

    public static String repositoryLink(String repository) {
        return "a[href='/" + repository + "']";
    }
}
