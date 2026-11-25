package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.FormsSection;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoPage {

    private final SelenideElement formsTab = $(byText("Формы"));

    @Step("Открываем раздел «Формы»")
    public FormsSection openForms() {
        formsTab.click();
        return new FormsSection();
    }
}
