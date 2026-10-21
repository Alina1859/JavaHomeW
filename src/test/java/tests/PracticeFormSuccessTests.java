package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormSuccessTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void practiceFormSuccessTest() {
        practiceFormPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setUserEmail(USER_EMAIL)
                .setGender(GENDER)
                .setUserNumber(PHONE)
                .setDateOfBirth(BIRTH_DAY, BIRTH_MONTH, BIRTH_YEAR)
                .setSubject(SUBJECT)
                .setHobby(HOBBY)
                .uploadPicture(PICTURE)
                .setCurrentAddress(FULL_ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .submit();

        assertEquals(SUBMIT_TITLE, practiceFormPage.getModalTitle());
        assertEquals(USER_NAME, practiceFormPage.getResutTableStudentName());
        assertEquals(USER_EMAIL, practiceFormPage.getResutTableStudentEmail());
        assertEquals(GENDER, practiceFormPage.getResutTableGender());
        assertEquals(PHONE, practiceFormPage.getResutTableMobile());
        assertEquals(BIRTH_DATE, practiceFormPage.getResutTableDateOfBirth());
        assertEquals(SUBJECT, practiceFormPage.getResutTableSubjects());
        assertEquals(HOBBY, practiceFormPage.getResutTableHobbies());
        assertEquals(PICTURE, practiceFormPage.getResutTablePicture());
        assertEquals(FULL_ADDRESS, practiceFormPage.getResutTableAddress());
        assertEquals(STATE + " " + CITY, practiceFormPage.getResutTableStateAndCity());
    }
}
