package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Locators;
import helpers.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(TestData.BASE_URL);

        $(Locators.SEARCH_BUTTON).click();
        $(Locators.SEARCH_INPUT).sendKeys(TestData.REPOSITORY);
        $(Locators.SEARCH_INPUT).pressEnter();

        $(Locators.repositoryLink(TestData.REPOSITORY)).click();
        $(Locators.ISSUES_TAB).click();
        $(withText(TestData.ISSUE_NAME)).should(Condition.exist);
    }
}
