package tests;

import static helpers.DataTest.*;
import static io.qameta.allure.Allure.step;

import helpers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LeadsPage;

@DisplayName("Проверка отчёта: этот тест специально падает")
public class ShouldFailTest extends BaseTest {

    private final LeadsPage leadsPage = new LeadsPage();

    @Test
    @DisplayName("Ждём неверный текст заглушки")
    void shouldFailTest() {
        step("Открываем раздел «Заявки»", () ->
                leadsPage.open().openApplications());

        step("Вводим в поиск несуществующее значение", () ->
                leadsPage.searchFor(NON_EXISTING_SEARCH_VALUE));

        step("Проверяем заведомо неверный текст заглушки", () ->
                leadsPage.checkNoResultsTitle(WRONG_NO_RESULTS_TITLE));
    }
}
