package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementsCondition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private static final String DEMO_PATH = "/demo";

    private final SelenideElement
            applicationsLink = $("[data-testid='sidebar-nav-leads']"),
            visitorsLink = $("[data-testid='sidebar-nav-visitors']");

    @Step("Открываем демо")
    public BasePage open() {
        Selenide.open(DEMO_PATH);
        return this;
    }

    @Step("Переходим в раздел «Заявки» по кнопке в меню")
    public LeadsPage openApplications() {
        applicationsLink.click();
        return new LeadsPage();
    }

    @Step("Переходим в раздел «Посетители» по кнопке в меню")
    public VisitorsPage openVisitors() {
        visitorsLink.click();
        return new VisitorsPage();
    }

    protected static WebElementsCondition everyRowHasText(String expected) {
        return allMatch("text \"" + expected + "\"", row -> row.getText().contains(expected));
    }
}
