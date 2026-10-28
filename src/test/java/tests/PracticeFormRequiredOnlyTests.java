package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import net.datafaker.Faker;
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
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phone = faker.number().digits(10);

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
