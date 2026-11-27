package tests;

import static io.qameta.allure.Allure.step;

import helpers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LeadsPage;

@DisplayName("Заявки: поиск по телефону")
public class FindRequestByPhoneTest extends BaseTest {

    private final LeadsPage leadsPage = new LeadsPage();

    @Test
    @DisplayName("Поиск по телефону находит заявку с этим телефоном")
    void findRequestByPhoneTest() {
        step("Открываем раздел «Заявки»", () ->
                leadsPage.open().openApplications());

        step("Вводим в поиск телефон первой заявки", leadsPage::searchByFirstRequestPhone);

        step("Проверяем результат", leadsPage::checkFirstRequestIsFound);
    }
}
