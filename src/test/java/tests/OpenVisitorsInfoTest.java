package tests;

import static io.qameta.allure.Allure.step;

import helpers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VisitorsPage;

@DisplayName("Посетители: открытие информации о посетителе")
public class OpenVisitorsInfoTest extends BaseTest {

    private final VisitorsPage visitorsPage = new VisitorsPage();

    @Test
    @DisplayName("Клик по посетителю в списке открывает его карточку")
    void openVisitorsInfoTest() {
        step("Открываем раздел «Посетители»", () ->
                visitorsPage.open().openVisitors());

        step("Открываем карточку второго посетителя в списке", visitorsPage::openSecondVisitor);

        step("Проверяем результат", () ->
                visitorsPage.checkVisitorCardTitle()
                        .checkVisitorCard(visitorsPage.getSecondVisitorCity(), visitorsPage.getSecondVisitorLastVisit()));
    }
}
