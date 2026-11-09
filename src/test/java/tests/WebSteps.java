package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Locators;
import helpers.TestData;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open(TestData.BASE_URL);
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(Locators.SEARCH_BUTTON).click();
        $(Locators.SEARCH_INPUT).sendKeys(repo);
        $(Locators.SEARCH_INPUT).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(Locators.repositoryLink(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $(Locators.ISSUES_TAB).click();
    }

    @Step("Проверяем наличие Issue с именем {issueName}")
    public void issueWithNameShouldBeVisible(String issueName) {
        $(withText(issueName)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
