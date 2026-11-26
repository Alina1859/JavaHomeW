package tests;

import static helpers.TestData.*;
import static io.qameta.allure.Allure.step;

import helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DemoPage;
import pages.components.VisitorCard;

@DisplayName("Посетители: открытие информации о посетителе")
public class OpenVisitorsInfoTest extends TestBase {

    private final DemoPage demoPage = new DemoPage();
    private final VisitorCard visitorCard = new VisitorCard();

    @Test
    @DisplayName("Клик по посетителю в списке открывает его карточку")
    void openVisitorsInfoTest() {
        step("Открываем раздел «Посетители»", () ->
                demoPage.open().openVisitors());

        step("Кликаем по первому посетителю в списке", demoPage::openFirstVisitor);

        step("Проверяем результат", () ->
                visitorCard.checkTitle(VISITOR_CARD_TITLE)
                        .checkVisitor(demoPage.getFirstVisitorCity(), demoPage.getFirstVisitorLastVisit()));
    }
}
