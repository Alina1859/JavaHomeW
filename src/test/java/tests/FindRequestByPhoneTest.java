package tests;

import static io.qameta.allure.Allure.step;

import helpers.BaseTest;
import models.RequestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DemoPage;

@DisplayName("Заявки: поиск по телефону")
public class FindRequestByPhoneTest extends BaseTest {

    private final DemoPage demoPage = new DemoPage();

    @Test
    @DisplayName("Поиск по телефону находит заявку с этим телефоном")
    void findRequestByPhoneTest() {
        step("Открываем раздел «Заявки»", () ->
                demoPage.open().openApplications());

        RequestData request = demoPage.getFirstRequestData();

        step("Вводим в поиск телефон этой заявки", () ->
                demoPage.searchFor(request.phone()));

        step("Проверяем результат", () ->
                demoPage.checkRequestIsFound(request));
    }
}
