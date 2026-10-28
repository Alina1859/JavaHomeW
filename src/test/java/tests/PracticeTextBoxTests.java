package tests;

import helpers.TestBase;
import net.datafaker.Faker;
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
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().streetAddress();
        String permanentAddress = faker.address().streetAddress();

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

    @ParameterizedTest(name = "Некорректный email {0} отклоняется")
    @MethodSource("helpers.TestData#invalidEmails")
    void textBoxInvalidEmailIsRejected(String email) {
        Faker faker = new Faker();
        textBoxPage.open()
                .setUserName(faker.name().fullName())
                .setUserEmail(email)
                .setCurrentAddress(faker.address().streetAddress())
                .setPermanentAddress(faker.address().streetAddress())
                .submit();

        assertTrue(textBoxPage.getUserEmailClass().contains("field-error"),
                "Email should be rejected: " + email);
    }
}
