package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import helpers.DataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import pages.PracticeFormPage;

import static utils.RandomUtils.getRandomItemFromList;

@DisplayName("Форма: валидация полей")
public class PracticeFormNegativeTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Пустая форма подсвечивает обязательные поля и не отправляется")
    void practiceFormRequiredNotFilledTest() {
        String gender = getRandomItemFromList(GENDERS);
        practiceFormPage.open().submit();
        practiceFormPage.checkFirstNameBorderColor("rgb(220, 53, 69)");
        practiceFormPage.checkLastNameBorderColor("rgb(220, 53, 69)");
        practiceFormPage.checkUserNumberBorderColor("rgb(220, 53, 69)");
        practiceFormPage.waitForGenderColor(gender, "rgba(220, 53, 69, 1)");
        assertEquals("rgba(220, 53, 69, 1)", practiceFormPage.getGenderColor(gender));
    }

    @MethodSource("helpers.TestData#invalidPhones")
    @ParameterizedTest(name = "Короткий номер {0} отклоняется")
    void practiceFormNotValidMobile(String phone) {
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String gender = getRandomItemFromList(GENDERS);

        practiceFormPage.open()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phone)
                .submit();
        practiceFormPage.checkUserNumberBorderColor("rgb(220, 53, 69)");
    }

    @MethodSource("helpers.TestData#invalidEmails")
    @ParameterizedTest(name = "Некорректный email {0} отклоняется")
    void practiceFormInvalidEmail(String email) {
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String phone = DataGenerator.getRandomPhone();
        String gender = getRandomItemFromList(GENDERS);

        practiceFormPage.open()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phone)
                .setUserEmail(email)
                .submit();
        practiceFormPage.checkUserEmailBorderColor("rgb(220, 53, 69)");
    }

    @CsvSource({UNKNOWN_SUBJECT_CYRILLIC, UNKNOWN_SUBJECT_LATIN})
    @ParameterizedTest(name = "Неизвестный предмет {0} не попадает в результат")
    void practiceFormUnknownSubject(String subject) {
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String phone = DataGenerator.getRandomPhone();
        String gender = getRandomItemFromList(GENDERS);

        practiceFormPage.open()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phone)
                .typeSubject(subject)
                .submit();

        practiceFormPage.checkModalTitle(SUBMIT_TITLE);
        assertEquals(firstName + " " + lastName, practiceFormPage.getResult("Student Name"));
        assertEquals(gender, practiceFormPage.getResult("Gender"));
        assertEquals(phone, practiceFormPage.getResult("Mobile"));
        assertEquals("", practiceFormPage.getResult("Subjects"));
    }
}
