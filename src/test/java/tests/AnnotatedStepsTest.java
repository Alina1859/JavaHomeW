package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(TestData.REPOSITORY);
        steps.clickOnRepositoryLink(TestData.REPOSITORY);
        steps.openIssuesTab();
        steps.takeScreenshot();
        steps.issueWithNameShouldBeVisible(TestData.ISSUE_NAME);
    }
}
