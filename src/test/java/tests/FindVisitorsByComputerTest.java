package tests;

import static helpers.DataTest.*;
import static io.qameta.allure.Allure.step;

import helpers.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VisitorsPage;

@DisplayName("Посетители: фильтр по устройству")
public class FindVisitorsByComputerTest extends BaseTest {

    private final VisitorsPage visitorsPage = new VisitorsPage();

    @Test
    @DisplayName("Фильтр «Компьютер» оставляет в списке только посетителей с компьютера")
    void findVisitorsByComputerTest() {
        step("Открываем раздел «Посетители»", () ->
                visitorsPage.open().openVisitors());

        step("Включаем в фильтре «Устройство» значение «Компьютер»", () ->
                visitorsPage.openDeviceFilter().selectDesktop().closeFilters());

        step("Проверяем результат", () ->
                visitorsPage.checkVisitorsHaveDevice(DEVICE_COMPUTER));
    }
}
