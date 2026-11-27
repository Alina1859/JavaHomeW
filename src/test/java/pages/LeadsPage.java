package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.RequestData;

import static com.codeborne.selenide.Condition.allOf;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.DataTest.NO_RESULTS_TEXT;
import static helpers.DataTest.NO_RESULTS_TITLE;

public class LeadsPage extends BasePage {

    private final SelenideElement
            searchField = $("[data-testid='leads-filters-search']"),
            emptyState = $("[data-testid='leads-empty-filtered']");

    private final ElementsCollection requestRows = $$("[data-testid='leads-table-row']");

    private RequestData firstRequest;

    @Step("Ищем по телефону первой заявки из списка")
    public LeadsPage searchByFirstRequestPhone() {
        firstRequest = readFirstRequestData();
        searchField.setValue(firstRequest.phone());
        return this;
    }

    @Step("Проверяем, что нашлась первая заявка")
    public LeadsPage checkFirstRequestIsFound() {
        requestRows.shouldHave(everyRowHasText(firstRequest.phone()));
        requestRows.findBy(allOf(text(firstRequest.name()), text(firstRequest.phone()))).shouldBe(visible);
        return this;
    }

    private RequestData readFirstRequestData() {
        SelenideElement contact = requestRows.first().$("div.flex-1");
        return new RequestData(
                contact.$(".text-14-medium span").getText(),
                contact.$(".text-12-regular").getText());
    }

    @Step("Ищем «{value}»")
    public LeadsPage searchFor(String value) {
        searchField.setValue(value);
        return this;
    }

    @Step("Проверяем заглушку пустого результата")
    public LeadsPage checkNoResults() {
        return checkNoResultsTitle(NO_RESULTS_TITLE).checkNoResultsText(NO_RESULTS_TEXT);
    }

    public LeadsPage checkNoResultsTitle(String title) {
        emptyState.shouldHave(text(title));
        return this;
    }

    public LeadsPage checkNoResultsText(String expected) {
        emptyState.shouldHave(text(expected));
        return this;
    }
}
