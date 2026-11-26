package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VisitorCard {

    private final SelenideElement card = $("[role='dialog']");
    private final SelenideElement title = $("[role='dialog'] [data-slot='dialog-title']");

    @Step("Проверяем заголовок карточки «{expected}»")
    public VisitorCard checkTitle(String expected) {
        title.shouldHave(text(expected));
        return this;
    }

    @Step("Проверяем, что это карточка посетителя из «{city}» с последним визитом {lastVisit}")
    public VisitorCard checkVisitor(String city, String lastVisit) {
        card.shouldHave(text(city), text(lastVisit));
        return this;
    }
}
