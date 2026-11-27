package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VisitorCard {

    private final SelenideElement
            card = $("[data-testid='visitor-card']"),
            title = $("[data-testid='visitor-card'] [data-slot='dialog-title']"),
            nextButton = $("[data-testid='visitor-card-next']");

    @Step("Проверяем заголовок карточки «{expected}»")
    public void checkTitle(String expected) {
        title.shouldHave(text(expected));
    }

    @Step("Проверяем, что это карточка посетителя из «{city}» с последним визитом {lastVisit}")
    public void checkVisitor(String city, String lastVisit) {
        card.shouldHave(text(city), text(lastVisit));
    }

    public void next() {
        card.shouldHave(cssValue("translate", "none"));
        nextButton.click();
    }
}
