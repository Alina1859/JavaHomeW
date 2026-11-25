package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byPlaceholder;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ApplicationsPage {

    private static final String APPLICATIONS_URL =
            "/projects/01a19613-12cb-7c93-a187-05f94bc6a4cc/applications";

    private final SelenideElement searchField =
            $(byPlaceholder("Поиск по телефону, имени, ID заявки или комментарию"));

    public ApplicationsPage open() {
        Selenide.open(APPLICATIONS_URL);
        return this;
    }

    @Step("Ищем «{value}»")
    public ApplicationsPage searchFor(String value) {
        searchField.setValue(value);
        return this;
    }

    @Step("Проверяем заглушку пустого результата")
    public ApplicationsPage checkNoResults() {
        $(byText("Заявки не найдены")).shouldBe(visible);
        $(byText("Измените условия поиска или сбросьте фильтры.")).shouldBe(visible);
        return this;
    }
}
