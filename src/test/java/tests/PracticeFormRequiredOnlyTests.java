package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;
import pages.PracticeFormPage;

@DisplayName("Форма: только обязательные поля")
public class PracticeFormRequiredOnlyTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @CsvSource({GENDER, GENDER_FEMALE, GENDER_OTHER})
    @ParameterizedTest(name = "Отправка обязательных полей: пол {0}")
    void practiceFormRequiredOnlyTest(String gender) {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(gender)
                .setUserNumber(PHONE)
                .submit();

        assertEquals(SUBMIT_TITLE, practiceFormPage.getModalTitle());
        assertEquals(USER_NAME, practiceFormPage.getResult("Student Name"));
        assertEquals(gender, practiceFormPage.getResult("Gender"));
        assertEquals(PHONE, practiceFormPage.getResult("Mobile"));
    }
}
