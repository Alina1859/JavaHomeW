package tests;

import helpers.TestBase;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeTextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxAllFieldsTest() {
        textBoxPage.open()
                .setUserName(USER_NAME)
                .setUserEmail(USER_EMAIL)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setPermanentAddress(PERMANENT_ADDRESS)
                .submit();

        assertEquals("Name:" + USER_NAME, textBoxPage.getOutputName());
        assertEquals("Email:" + USER_EMAIL, textBoxPage.getOutputEmail());
        assertEquals("Current Address :" + CURRENT_ADDRESS, textBoxPage.getOutputCurrentAddress());
        assertEquals("Permananet Address :" + PERMANENT_ADDRESS, textBoxPage.getOutputPermanentAddress());
    }

    @Test
    void textBoxInvalidEmailIsRejected() {
        textBoxPage.open()
                .setUserName(USER_NAME)
                .setUserEmail(INVALID_EMAIL)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setPermanentAddress(PERMANENT_ADDRESS)
                .submit();

        assertTrue(textBoxPage.getUserEmailClass().contains("field-error"));
    }
}
