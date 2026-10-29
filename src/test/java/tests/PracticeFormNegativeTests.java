package tests;

import static helpers.TestData.*;

import helpers.TestBase;
import helpers.DataGenerator;
import models.RequiredFormData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import pages.PracticeFormPage;


@DisplayName("Форма: валидация полей")
public class PracticeFormNegativeTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Пустая форма подсвечивает обязательные поля и не отправляется")
    void practiceFormRequiredNotFilledTest() {
        RequiredFormData data = DataGenerator.randomRequiredFormData();
        practiceFormPage.open().submit();
        practiceFormPage.checkFirstNameBorderColor(ERROR_BORDER_COLOR);
        practiceFormPage.checkLastNameBorderColor(ERROR_BORDER_COLOR);
        practiceFormPage.checkUserNumberBorderColor(ERROR_BORDER_COLOR);
        practiceFormPage.waitForGenderColor(data.gender(), ERROR_TEXT_COLOR);
    }

    @Test
    @DisplayName("Невалидный номер телефона подсвечивается ошибкой")
    void practiceFormNotValidMobile() {
        RequiredFormData data = DataGenerator.randomRequiredFormData();

        practiceFormPage.open()
                .setFirstName(data.firstName())
                .setLastName(data.lastName())
                .setGender(data.gender())
                .setUserNumber(INVALID_PHONE)
                .submit();
        practiceFormPage.checkUserNumberBorderColor(ERROR_BORDER_COLOR);
    }

    @Test
    @DisplayName("Невалидный email подсвечивается ошибкой")
    void practiceFormInvalidEmail() {
        RequiredFormData data = DataGenerator.randomRequiredFormData();

        practiceFormPage.open()
                .setFirstName(data.firstName())
                .setLastName(data.lastName())
                .setGender(data.gender())
                .setUserNumber(data.phone())
                .setUserEmail(INVALID_EMAIL)
                .submit();
        practiceFormPage.checkUserEmailBorderColor(ERROR_BORDER_COLOR);
    }

    @Test
    @DisplayName("Неизвестный предмет не добавляется в форму")
    void practiceFormUnknownSubject() {
        RequiredFormData data = DataGenerator.randomRequiredFormData();

        practiceFormPage.open()
                .setFirstName(data.firstName())
                .setLastName(data.lastName())
                .setGender(data.gender())
                .setUserNumber(data.phone())
                .typeSubject(UNKNOWN_SUBJECT)
                .submit();

        practiceFormPage.checkModalTitle(SUBMIT_TITLE)
                .checkResult(data.firstName() + " " + data.lastName(),
                        practiceFormPage.getResult("Student Name"))
                .checkResult(data.gender(), practiceFormPage.getResult("Gender"))
                .checkResult(data.phone(), practiceFormPage.getResult("Mobile"))
                .checkResult("", practiceFormPage.getResult("Subjects"));
    }
}
