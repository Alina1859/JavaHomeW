package tests;

import static helpers.TestData.*;

import helpers.TestBase;
import helpers.DataGenerator;
import models.RequiredFormData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

@DisplayName("Форма: только обязательные поля")
public class PracticeFormRequiredOnlyTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Отправка формы только с обязательными полями")
    void practiceFormRequiredOnlyTest() {
        RequiredFormData data = DataGenerator.randomRequiredFormData();

        practiceFormPage.open()
                .setFirstName(data.firstName())
                .setLastName(data.lastName())
                .setGender(data.gender())
                .setUserNumber(data.phone())
                .submit();

        practiceFormPage.checkModalTitle(SUBMIT_TITLE)
                .checkResult(data.firstName() + " " + data.lastName(),
                        practiceFormPage.getResult("Student Name"))
                .checkResult(data.gender(), practiceFormPage.getResult("Gender"))
                .checkResult(data.phone(), practiceFormPage.getResult("Mobile"));
    }
}
