package tests;

import static helpers.DataTest.*;
import static io.qameta.allure.Allure.step;

import helpers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DemoPage;

@DisplayName("Посетители: фильтр по устройству")
public class FindVisitorsByComputerTest extends BaseTest {

    private final DemoPage demoPage = new DemoPage();

    @Test
    @DisplayName("Фильтр «Компьютер» оставляет в списке только посетителей с компьютера")
    void findVisitorsByComputerTest() {
        step("Открываем раздел «Посетители»", () ->
                demoPage.open().openVisitors());

        step("Включаем в фильтре «Устройство» значение «Компьютер»", () ->
                demoPage.openDeviceFilter().selectDevice(DEVICE_COMPUTER).closeFilters());

        step("Проверяем результат", () ->
                demoPage.checkVisitorsHaveDevice(DEVICE_COMPUTER));
    }
}
