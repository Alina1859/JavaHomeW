package tests;

import static helpers.TestData.*;
import static io.qameta.allure.Allure.step;

import helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DemoPage;

@DisplayName("Заявки: поиск по несуществующему значению")
public class FindNotExistingRequestTest extends TestBase {

    private final DemoPage demoPage = new DemoPage();

    @Test
    @DisplayName("Поиск по несуществующему значению показывает заглушку «Заявки не найдены»")
    void findNotExistingRequestTest() {
        step("Открываем раздел «Заявки»", () ->
                demoPage.open().openApplications());

        step("Вводим в поиск несуществующее значение", () ->
                demoPage.searchFor(NON_EXISTING_SEARCH_VALUE));

        step("Проверяем результат", demoPage::checkNoResults);
    }
}
