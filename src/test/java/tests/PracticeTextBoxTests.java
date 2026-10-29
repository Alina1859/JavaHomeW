package tests;

import helpers.TestBase;
import helpers.DataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.TextBoxPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Text Box: отправка данных и валидация email")
public class PracticeTextBoxTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxAllFieldsTest() {
        DataGenerator.TextBoxData data = DataGenerator.randomTextBoxData();

        textBoxPage.open()
                .setUserName(data.name())
                .setUserEmail(data.email())
                .setCurrentAddress(data.currentAddress())
                .setPermanentAddress(data.permanentAddress())
                .submit();

        assertEquals("Name:" + data.name(), textBoxPage.getOutputName());
        assertEquals("Email:" + data.email(), textBoxPage.getOutputEmail());
        assertEquals("Current Address :" + data.currentAddress(), textBoxPage.getOutputCurrentAddress());
        assertEquals("Permananet Address :" + data.permanentAddress(), textBoxPage.getOutputPermanentAddress());
    }

    @ParameterizedTest(name = "Некорректный email отклоняется, набор {index}")
    @MethodSource("helpers.DataGenerator#invalidTextBoxEmailData")
    void textBoxInvalidEmailIsRejected(DataGenerator.TextBoxData data) {
        textBoxPage.open()
                .setUserName(data.name())
                .setUserEmail(data.email())
                .setCurrentAddress(data.currentAddress())
                .setPermanentAddress(data.permanentAddress())
                .submit();

        assertTrue(textBoxPage.getUserEmailClass().contains("field-error"),
                "Email should be rejected: " + data.email());
    }
}
