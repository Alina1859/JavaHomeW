package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byPlaceholder;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoPage {

    private final SelenideElement applicationsLink = $(byText("Заявки"));
    private final SelenideElement formsTab = $(byText("Формы"));

    private final SelenideElement searchField =
            $(byPlaceholder("Поиск по телефону, имени, ID заявки или комментарию"));

    @Step("Переходим в раздел «Заявки» по кнопке в меню")
    public DemoPage openApplications() {
        applicationsLink.click();
        return this;
    }

    @Step("Ищем «{value}»")
    public DemoPage searchFor(String value) {
        searchField.setValue(value);
        return this;
    }

    @Step("Проверяем заглушку пустого результата")
    public DemoPage checkNoResults() {
        $(byText(TestData.NO_RESULTS_TITLE)).shouldBe(visible);
        $(byText(TestData.NO_RESULTS_TEXT)).shouldBe(visible);
        return this;
    }
}
