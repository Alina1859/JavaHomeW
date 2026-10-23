package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import pages.PracticeFormPage;

@DisplayName("Форма: заполнение всех полей")
public class PracticeFormSuccessTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    static Stream<Arguments> validFormData() {
        return Stream.of(
                Arguments.of(FIRST_NAME, LAST_NAME, USER_EMAIL, FULL_ADDRESS, STATE, CITY),
                Arguments.of(SECOND_FIRST_NAME, SECOND_LAST_NAME, SECOND_USER_EMAIL,
                        SECOND_FULL_ADDRESS, SECOND_STATE, SECOND_CITY)
        );
    }

    @MethodSource("validFormData")
    @ParameterizedTest(name = "Полная форма: {0} {1}, штат {4}, город {5}")
    void practiceFormSuccessTest(String firstName, String lastName, String email,
                                 String address, String state, String city) {
        practiceFormPage.open()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(GENDER)
                .setUserNumber(PHONE)
                .setDateOfBirth(BIRTH_DAY, BIRTH_MONTH, BIRTH_YEAR)
                .setSubject(SUBJECT)
                .setHobby(HOBBY)
                .uploadPicture(PICTURE)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        assertEquals(SUBMIT_TITLE, practiceFormPage.getModalTitle());
        assertEquals(firstName + " " + lastName, practiceFormPage.getResult("Student Name"));
        assertEquals(email, practiceFormPage.getResult("Student Email"));
        assertEquals(GENDER, practiceFormPage.getResult("Gender"));
        assertEquals(PHONE, practiceFormPage.getResult("Mobile"));
        assertEquals(BIRTH_DATE, practiceFormPage.getResult("Date of Birth"));
        assertEquals(SUBJECT, practiceFormPage.getResult("Subjects"));
        assertEquals(HOBBY, practiceFormPage.getResult("Hobbies"));
        assertEquals(PICTURE, practiceFormPage.getResult("Picture"));
        assertEquals(address, practiceFormPage.getResult("Address"));
        assertEquals(state + " " + city, practiceFormPage.getResult("State and City"));
    }
}
