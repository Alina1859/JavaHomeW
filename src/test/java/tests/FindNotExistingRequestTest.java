package tests;

import helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ApplicationsPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Заявки: поиск по несуществующему значению")
public class FindNotExistingRequestTest extends TestBase {

    private final ApplicationsPage applicationsPage = new ApplicationsPage();

    @Test
    @DisplayName("Поиск по несуществующему значению показывает заглушку «Заявки не найдены»")
    void searchNonExistingValueShowsEmptyState() {
        step("Открываем страницу заявок", () ->
                applicationsPage.open());

        step("Вводим в поиск несуществующее значение", () ->
                applicationsPage.searchFor("zzzzqqq12345"));

        step("Проверяем, что появилась заглушка пустого результата", () ->
                applicationsPage.checkNoResults());
    }
}
