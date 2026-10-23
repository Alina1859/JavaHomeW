package tests;

import helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import pages.TextBoxPage;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Text Box: отправка данных и валидация email")
public class PracticeTextBoxTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @CsvFileSource(resources = "/text_box_users.csv", numLinesToSkip = 1)
    @ParameterizedTest(name = "Отправка всех полей: {0}, {1}")
    void textBoxAllFieldsTest(String name, String email, String currentAddress, String permanentAddress) {
        textBoxPage.open()
                .setUserName(name)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit();

        assertEquals("Name:" + name, textBoxPage.getOutputName());
        assertEquals("Email:" + email, textBoxPage.getOutputEmail());
        assertEquals("Current Address :" + currentAddress, textBoxPage.getOutputCurrentAddress());
        assertEquals("Permananet Address :" + permanentAddress, textBoxPage.getOutputPermanentAddress());
    }

    @CsvSource({EMAIL_WITHOUT_AT, EMAIL_WITHOUT_DOMAIN, EMAIL_WITHOUT_NAME})
    @ParameterizedTest(name = "Некорректный email {0} отклоняется")
    void textBoxInvalidEmailIsRejected(String email) {
        textBoxPage.open()
                .setUserName(USER_NAME)
                .setUserEmail(email)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setPermanentAddress(PERMANENT_ADDRESS)
                .submit();

        assertTrue(textBoxPage.getUserEmailClass().contains("field-error"));
    }
}
