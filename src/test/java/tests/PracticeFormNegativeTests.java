package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormNegativeTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void practiceFormRequiredNotFilledTest() {
        practiceFormPage.open().submit();

        practiceFormPage.checkFirstNameBorderColor("rgb(220, 53, 69)");
        practiceFormPage.checkLastNameBorderColor("rgb(220, 53, 69)");
        practiceFormPage.checkUserNumberBorderColor("rgb(220, 53, 69)");
        practiceFormPage.checkGenderColor(GENDER, "rgba(220, 53, 69, 1)");
    }

    @Test
    void practiceFormNotValidMobile() {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(INVALID_PHONE)
                .submit();

        practiceFormPage.checkUserNumberBorderColor("rgb(220, 53, 69)");
    }

    @Test
    void practiceFormInvalidEmail() {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(PHONE)
                .setUserEmail(INVALID_EMAIL)
                .submit();

        practiceFormPage.checkUserEmailBorderColor("rgb(220, 53, 69)");
    }

    @Test
    void practiceFormUnknownSubject() {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(PHONE)
                .typeSubject(UNKNOWN_SUBJECT)
                .submit();

        assertEquals(SUBMIT_TITLE, practiceFormPage.getModalTitle());
        assertEquals(USER_NAME, practiceFormPage.getResutTableStudentName());
        assertEquals(GENDER, practiceFormPage.getResutTableGender());
        assertEquals(PHONE, practiceFormPage.getResutTableMobile());
        assertEquals("", practiceFormPage.getResutTableSubjects());
    }
}
