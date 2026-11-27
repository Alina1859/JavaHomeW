package tests;

import static io.qameta.allure.Allure.step;

import helpers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VisitorsPage;

@DisplayName("Посетители: переход к следующему посетителю в карточке")
public class NextVisitorInCardTest extends BaseTest {

    private final VisitorsPage visitorsPage = new VisitorsPage();

    @Test
    @DisplayName("Кнопка «Следующий посетитель» открывает карточку следующего посетителя из списка")
    void nextVisitorInCardTest() {
        step("Открываем раздел «Посетители»", () ->
                visitorsPage.open().openVisitors());

        step("Открываем карточку первого посетителя", () ->
                visitorsPage.openFirstVisitor()
                        .checkVisitorCard(visitorsPage.getFirstVisitorCity(), visitorsPage.getFirstVisitorLastVisit()));

        step("Переходим к следующему посетителю", visitorsPage::nextVisitor);

        step("Проверяем результат", () ->
                visitorsPage.checkVisitorCard(visitorsPage.getSecondVisitorCity(), visitorsPage.getSecondVisitorLastVisit()));
    }
}
