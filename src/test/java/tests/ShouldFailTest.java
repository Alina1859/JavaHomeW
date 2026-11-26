package tests;

import static helpers.TestData.*;
import static io.qameta.allure.Allure.step;

import helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DemoPage;

@DisplayName("Проверка отчёта: этот тест специально падает")
public class ShouldFailTest extends TestBase {

    private final DemoPage demoPage = new DemoPage();

    @Test
    @DisplayName("Ждём неверный текст заглушки")
    void shouldFailTest() {
        step("Открываем раздел «Заявки»", () ->
                demoPage.open().openApplications());

        step("Вводим в поиск несуществующее значение", () ->
                demoPage.searchFor(NON_EXISTING_SEARCH_VALUE));

        step("Проверяем заведомо неверный текст заглушки", () ->
                demoPage.checkNoResultsTitle(WRONG_NO_RESULTS_TITLE));
    }
}
