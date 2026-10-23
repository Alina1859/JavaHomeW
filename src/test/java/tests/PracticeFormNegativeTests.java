package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import pages.PracticeFormPage;

@DisplayName("Форма: валидация полей")
public class PracticeFormNegativeTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Пустая форма подсвечивает обязательные поля и не отправляется")
    void practiceFormRequiredNotFilledTest() {
        practiceFormPage.open().submit();
        practiceFormPage.checkFirstNameBorderColor("rgb(220, 53, 69)");
        practiceFormPage.checkLastNameBorderColor("rgb(220, 53, 69)");
        practiceFormPage.checkUserNumberBorderColor("rgb(220, 53, 69)");
        practiceFormPage.waitForGenderColor(GENDER, "rgba(220, 53, 69, 1)");
        assertEquals("rgba(220, 53, 69, 1)", practiceFormPage.getGenderColor(GENDER));
    }

    @CsvSource({PHONE_ONE_DIGIT, PHONE_FIVE_DIGITS, PHONE_NINE_DIGITS})
    @ParameterizedTest(name = "Короткий номер {0} отклоняется")
    void practiceFormNotValidMobile(String phone) {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(phone)
                .submit();
        practiceFormPage.checkUserNumberBorderColor("rgb(220, 53, 69)");
    }

    @CsvSource({EMAIL_WITHOUT_AT, EMAIL_WITHOUT_DOMAIN, EMAIL_WITHOUT_NAME})
    @ParameterizedTest(name = "Некорректный email {0} отклоняется")
    void practiceFormInvalidEmail(String email) {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(PHONE)
                .setUserEmail(email)
                .submit();
        practiceFormPage.checkUserEmailBorderColor("rgb(220, 53, 69)");
    }

    @CsvSource({UNKNOWN_SUBJECT_CYRILLIC, UNKNOWN_SUBJECT_LATIN})
    @ParameterizedTest(name = "Неизвестный предмет {0} не попадает в результат")
    void practiceFormUnknownSubject(String subject) {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(PHONE)
                .typeSubject(subject)
                .submit();

        assertEquals(SUBMIT_TITLE, practiceFormPage.getModalTitle());
        assertEquals(USER_NAME, practiceFormPage.getResult("Student Name"));
        assertEquals(GENDER, practiceFormPage.getResult("Gender"));
        assertEquals(PHONE, practiceFormPage.getResult("Mobile"));
        assertEquals("", practiceFormPage.getResult("Subjects"));
    }
}
