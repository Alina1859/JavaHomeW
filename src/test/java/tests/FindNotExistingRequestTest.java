package tests;

import helpers.TestBase;
import helpers.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DemoPage;
import pages.KvalityPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Заявки: поиск по несуществующему значению")
public class FindNotExistingRequestTest extends TestBase {

    private final KvalityPage kvalityPage = new KvalityPage();
    private DemoPage demoPage;

    @Test
    @DisplayName("Поиск по несуществующему значению показывает заглушку «Заявки не найдены»")
    void searchNonExistingValueShowsEmptyState() {
        step("Открываем главную и переходим в демо по кнопке «Посмотреть демо»", () ->
                demoPage = kvalityPage.open().openDemo());

        step("Переходим в раздел «Заявки» по кнопке в меню", () ->
                demoPage.openApplications());

        step("Вводим в поиск несуществующее значение", () ->
                demoPage.searchFor(TestData.NON_EXISTING_SEARCH_VALUE));

        step("Проверяем, что появилась заглушка пустого результата", () ->
                demoPage.checkNoResults());
    }
}
