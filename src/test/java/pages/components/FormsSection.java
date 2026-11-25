package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FormsSection {

    private final SelenideElement form = $("form");

    @Step("Проверяем, что форма отображается")
    public FormsSection checkFormVisible() {
        form.shouldBe(visible);
        return this;
    }
}
