package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.components.VisitorCard;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.actions;
import static helpers.DataTest.VISITOR_CARD_TITLE;

public class VisitorsPage extends BasePage {

    VisitorCard visitorCard = new VisitorCard();

    private static final String CITY = ".text-14-medium .truncate";
    private static final String LAST_VISIT = "span.flex-col.tabular-nums";

    private final SelenideElement
            deviceFilterButton = $("[data-testid='visitors-filter-device']"),
            desktopOption = $("[data-testid='visitors-filter-device-option-desktop']");

    private final ElementsCollection visitorRows = $$("[data-testid='visitors-table-row']");

    @Step("Открываем карточку первого посетителя")
    public VisitorsPage openFirstVisitor() {
        visitorRows.first().click();
        return this;
    }

    @Step("Открываем карточку второго посетителя")
    public VisitorsPage openSecondVisitor() {
        visitorRows.get(1).click();
        return this;
    }

    public String getFirstVisitorCity() {
        return getVisitorCity(0);
    }

    public String getFirstVisitorLastVisit() {
        return getVisitorLastVisit(0);
    }

    public String getSecondVisitorCity() {
        return getVisitorCity(1);
    }

    public String getSecondVisitorLastVisit() {
        return getVisitorLastVisit(1);
    }

    private String getVisitorCity(int index) {
        return visitorRows.get(index).$(CITY).getText();
    }

    private String getVisitorLastVisit(int index) {
        return visitorRows.get(index).$(LAST_VISIT).getText().replaceAll("\\s+", " ");
    }

    @Step("Проверяем заголовок карточки посетителя")
    public VisitorsPage checkVisitorCardTitle() {
        visitorCard.checkTitle(VISITOR_CARD_TITLE);
        return this;
    }

    @Step("Проверяем, что в карточке посетитель из «{city}» с последним визитом {lastVisit}")
    public VisitorsPage checkVisitorCard(String city, String lastVisit) {
        visitorCard.checkVisitor(city, lastVisit);
        return this;
    }

    @Step("Переходим к следующему посетителю")
    public VisitorsPage nextVisitor() {
        visitorCard.next();
        return this;
    }

    @Step("Открываем фильтр «Устройство»")
    public VisitorsPage openDeviceFilter() {
        deviceFilterButton.click();
        return this;
    }

    @Step("Выбираем в фильтре компьютер")
    public VisitorsPage selectDesktop() {
        desktopOption.click();
        return this;
    }

    @Step("Закрываем окно фильтра")
    public VisitorsPage closeFilters() {
        actions().sendKeys(Keys.ESCAPE).perform();
        return this;
    }

    @Step("Проверяем, что в списке только посетители с устройства «{device}»")
    public VisitorsPage checkVisitorsHaveDevice(String device) {
        visitorRows.shouldHave(everyRowHasText(device));
        return this;
    }
}
