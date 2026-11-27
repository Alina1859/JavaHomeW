package tests;

import static helpers.DataTest.*;
import static io.qameta.allure.Allure.step;

import helpers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LeadsPage;

@DisplayName("Заявки: поиск по несуществующему значению")
public class FindNotExistingRequestTest extends BaseTest {

    private final LeadsPage leadsPage = new LeadsPage();

    @Test
    @DisplayName("Поиск по несуществующему значению показывает заглушку «Заявки не найдены»")
    void findNotExistingRequestTest() {
        step("Открываем раздел «Заявки»", () ->
                leadsPage.open().openApplications());

        step("Вводим в поиск несуществующее значение", () ->
                leadsPage.searchFor(NON_EXISTING_SEARCH_VALUE));

        step("Проверяем результат", leadsPage::checkNoResults);
    }
}
