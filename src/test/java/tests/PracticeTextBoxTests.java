package tests;

import helpers.TestBase;
import helpers.DataGenerator;
import helpers.TestData;
import models.TextBoxData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Text Box: отправка данных и валидация email")
public class PracticeTextBoxTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @DisplayName("Отправка Text Box со всеми полями")
    void textBoxAllFieldsTest() {
        TextBoxData data = DataGenerator.randomTextBoxData();

        step("Открываем страницу Text Box", () ->
                textBoxPage.open());

        step("Заполняем форму", () -> {
            textBoxPage.setUserName(data.name())
                    .setUserEmail(data.email())
                    .setCurrentAddress(data.currentAddress())
                    .setPermanentAddress(data.permanentAddress())
                    .submit();
        });

        step("Проверяем результат", () -> {
            textBoxPage.checkResult("Name:" + data.name(), textBoxPage.getOutputName())
                    .checkResult("Email:" + data.email(), textBoxPage.getOutputEmail())
                    .checkResult("Current Address :" + data.currentAddress(),
                            textBoxPage.getOutputCurrentAddress())
                    .checkResult("Permananet Address :" + data.permanentAddress(),
                            textBoxPage.getOutputPermanentAddress());
        });
    }

    @Test
    @DisplayName("Невалидный email подсвечивается ошибкой")
    void textBoxInvalidEmailIsRejected() {
        TextBoxData data = DataGenerator.randomTextBoxData(TestData.INVALID_EMAIL);

        step("Открываем страницу Text Box", () ->
                textBoxPage.open());

        step("Заполняем форму с невалидным email", () -> {
            textBoxPage.setUserName(data.name())
                    .setUserEmail(data.email())
                    .setCurrentAddress(data.currentAddress())
                    .setPermanentAddress(data.permanentAddress())
                    .submit();
        });

        step("Проверяем подсветку ошибки у email", () ->
                textBoxPage.checkUserEmailHasError());
    }
}
