package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementsCondition;
import io.qameta.allure.Step;
import models.RequestData;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.allOf;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byPlaceholder;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.actions;
import static helpers.DataTest.NO_RESULTS_TEXT;
import static helpers.DataTest.NO_RESULTS_TITLE;

public class DemoPage {

    private static final String DEMO_PATH = "/demo";

    private final SelenideElement applicationsLink = $(byText("Заявки"));
    private final SelenideElement visitorsLink = $(byText("Посетители"));
    private final SelenideElement formsTab = $(byText("Формы"));

    private final SelenideElement searchField =
            $(byPlaceholder("Поиск по телефону, имени, ID заявки или комментарию"));

    private final ElementsCollection visitorRows = $$("main div[role='button']");

    private final ElementsCollection requestRows =
            $$x("//main//button[@aria-label='Просмотр заявки']/ancestor::div[1]");

    private final SelenideElement deviceFilterButton = $(byText("Устройство"));
    private final SelenideElement filtersPopover = $("[data-slot='popover-content']");

    @Step("Открываем демо")
    public DemoPage open() {
        Selenide.open(DEMO_PATH);
        return this;
    }

    @Step("Переходим в раздел «Заявки» по кнопке в меню")
    public DemoPage openApplications() {
        applicationsLink.click();
        return this;
    }

    @Step("Переходим в раздел «Посетители» по кнопке в меню")
    public DemoPage openVisitors() {
        visitorsLink.click();
        return this;
    }

    public String getFirstVisitorCity() {
        return firstVisitorRow().$(".text-14-medium .truncate").getText();
    }

    public String getFirstVisitorLastVisit() {
        return firstVisitorRow().$("span.flex-col.tabular-nums").getText().replaceAll("\\s+", " ");
    }

    @Step("Открываем карточку первого посетителя")
    public DemoPage openFirstVisitor() {
        firstVisitorRow().click();
        return this;
    }

    private SelenideElement firstVisitorRow() {
        return visitorRows.first();
    }

    @Step("Запоминаем данные первой заявки из списка")
    public RequestData getFirstRequestData() {
        SelenideElement contact = requestRows.first().$("div.flex-1");
        return new RequestData(
                contact.$(".text-14-medium span").getText(),
                contact.$(".text-12-regular").getText());
    }

    @Step("Проверяем, что нашлась заявка: {request}")
    public DemoPage checkRequestIsFound(RequestData request) {
        requestRows.shouldHave(everyRowHasText(request.phone()));
        requestRows.findBy(allOf(text(request.name()), text(request.phone()))).shouldBe(visible);
        return this;
    }

    @Step("Открываем фильтр «Устройство»")
    public DemoPage openDeviceFilter() {
        deviceFilterButton.click();
        return this;
    }

    @Step("Выбираем в фильтре «{device}»")
    public DemoPage selectDevice(String device) {
        filtersPopover.$(byText(device)).click();
        return this;
    }

    @Step("Закрываем окно фильтра")
    public DemoPage closeFilters() {
        actions().sendKeys(Keys.ESCAPE).perform();
        return this;
    }

    @Step("Проверяем, что в списке только посетители с устройством «{device}»")
    public DemoPage checkVisitorsHaveDevice(String device) {
        visitorRows.shouldHave(everyRowHasText(device));
        return this;
    }

    private static WebElementsCondition everyRowHasText(String expected) {
        return allMatch("text \"" + expected + "\"", row -> row.getText().contains(expected));
    }

    @Step("Ищем «{value}»")
    public DemoPage searchFor(String value) {
        searchField.setValue(value);
        return this;
    }

    @Step("Проверяем заглушку пустого результата")
    public DemoPage checkNoResults() {
        return checkNoResultsTitle(NO_RESULTS_TITLE).checkNoResultsText(NO_RESULTS_TEXT);
    }

    public DemoPage checkNoResultsTitle(String title) {
        $(byText(title)).shouldBe(visible);
        return this;
    }

    public DemoPage checkNoResultsText(String text) {
        $(byText(text)).shouldBe(visible);
        return this;
    }
}
