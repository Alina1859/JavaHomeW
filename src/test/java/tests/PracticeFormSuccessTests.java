package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import helpers.DataGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import pages.PracticeFormPage;

@DisplayName("Форма: заполнение всех полей")
public class PracticeFormSuccessTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @MethodSource("helpers.DataGenerator#validFormData")
    @ParameterizedTest(name = "Полная форма: {0}")
    void practiceFormSuccessTest(DataGenerator.ValidFormData data) {
        practiceFormPage.open()
                .setFirstName(data.firstName())
                .setLastName(data.lastName())
                .setUserEmail(data.email())
                .setGender(data.gender())
                .setUserNumber(data.phone())
                .setDateOfBirth(data.birthDay(), data.birthMonth(), data.birthYear())
                .setSubject(data.subject())
                .setHobby(data.hobby())
                .uploadPicture(PICTURE)
                .setCurrentAddress(data.address())
                .setState(data.state())
                .setCity(data.city())
                .submit();

        practiceFormPage.checkModalTitle(SUBMIT_TITLE);
        assertEquals(data.firstName() + " " + data.lastName(), practiceFormPage.getResult("Student Name"));
        assertEquals(data.email(), practiceFormPage.getResult("Student Email"));
        assertEquals(data.gender(), practiceFormPage.getResult("Gender"));
        assertEquals(data.phone(), practiceFormPage.getResult("Mobile"));
        assertEquals(data.formattedBirthDate(), practiceFormPage.getResult("Date of Birth"));
        assertEquals(data.subject(), practiceFormPage.getResult("Subjects"));
        assertEquals(data.hobby(), practiceFormPage.getResult("Hobbies"));
        assertEquals(PICTURE, practiceFormPage.getResult("Picture"));
        assertEquals(data.address(), practiceFormPage.getResult("Address"));
        assertEquals(data.state() + " " + data.city(), practiceFormPage.getResult("State and City"));
    }
}
