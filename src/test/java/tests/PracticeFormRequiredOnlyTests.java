package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import helpers.DataGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import pages.PracticeFormPage;

@DisplayName("Форма: только обязательные поля")
public class PracticeFormRequiredOnlyTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @MethodSource("helpers.TestData#genders")
    @ParameterizedTest(name = "Отправка обязательных полей: пол {0}")
    void practiceFormRequiredOnlyTest(String gender) {
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String phone = DataGenerator.getRandomPhone();

        practiceFormPage.open()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phone)
                .submit();

        practiceFormPage.checkModalTitle(SUBMIT_TITLE);
        assertEquals(firstName + " " + lastName, practiceFormPage.getResult("Student Name"));
        assertEquals(gender, practiceFormPage.getResult("Gender"));
        assertEquals(phone, practiceFormPage.getResult("Mobile"));
    }
}
