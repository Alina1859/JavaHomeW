package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class KvalityPage {

    private final SelenideElement viewDemoButton = $(byText("Посмотреть демо"));

    public KvalityPage open() {
        Selenide.open("/");
        return this;
    }

    @Step("Открываем демо")
    public DemoPage openDemo() {
        viewDemoButton.click();
        return new DemoPage();
    }
}
