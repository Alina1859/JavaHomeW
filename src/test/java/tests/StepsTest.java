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
import static io.qameta.allure.Allure.step;

public class StepsTest {

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(TestData.BASE_URL);
        });

        step("Ищем репозиторий", () -> {
            $(Locators.SEARCH_BUTTON).click();
            $(Locators.SEARCH_INPUT).sendKeys(TestData.REPOSITORY);
            $(Locators.SEARCH_INPUT).pressEnter();
        });

        step("Кликаем по ссылке репозитория", () -> {
            $(Locators.repositoryLink(TestData.REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $(Locators.ISSUES_TAB).click();
        });
        step("Проверяем наличие Issue с именем " + TestData.ISSUE_NAME, () -> {
            $(withText(TestData.ISSUE_NAME)).should(Condition.exist);
        });
    }
}
