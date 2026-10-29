package tests;

import static helpers.TestData.*;

import helpers.TestBase;
import helpers.DataGenerator;
import models.ValidFormData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

@DisplayName("Форма: заполнение всех полей")
public class PracticeFormSuccessTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Успешная отправка формы со всеми полями")
    void practiceFormSuccessTest() {
        ValidFormData data = DataGenerator.randomValidFormData();

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

        practiceFormPage.checkModalTitle(SUBMIT_TITLE)
                .checkResult(data.firstName() + " " + data.lastName(),
                        practiceFormPage.getResult("Student Name"))
                .checkResult(data.email(), practiceFormPage.getResult("Student Email"))
                .checkResult(data.gender(), practiceFormPage.getResult("Gender"))
                .checkResult(data.phone(), practiceFormPage.getResult("Mobile"))
                .checkResult(data.formattedBirthDate(), practiceFormPage.getResult("Date of Birth"))
                .checkResult(data.subject(), practiceFormPage.getResult("Subjects"))
                .checkResult(data.hobby(), practiceFormPage.getResult("Hobbies"))
                .checkResult(PICTURE, practiceFormPage.getResult("Picture"))
                .checkResult(data.address(), practiceFormPage.getResult("Address"))
                .checkResult(data.state() + " " + data.city(),
                        practiceFormPage.getResult("State and City"));
    }
}
