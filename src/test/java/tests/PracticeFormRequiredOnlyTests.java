package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormRequiredOnlyTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void practiceFormRequiredOnlyTest() {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(PHONE)
                .submit();

        assertEquals(SUBMIT_TITLE, practiceFormPage.getModalTitle());
        assertEquals(USER_NAME, practiceFormPage.getResutTableStudentName());
        assertEquals(GENDER, practiceFormPage.getResutTableGender());
        assertEquals(PHONE, practiceFormPage.getResutTableMobile());
    }
}
