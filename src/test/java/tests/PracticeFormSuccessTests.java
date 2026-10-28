package tests;

import static helpers.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import helpers.TestBase;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import net.datafaker.Faker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import pages.PracticeFormPage;

import static utils.RandomUtils.getRandomItemFromList;

@DisplayName("Форма: заполнение всех полей")
public class PracticeFormSuccessTests extends TestBase {

    private final PracticeFormPage practiceFormPage = new PracticeFormPage();

    static Stream<Arguments> validFormData() {
        Faker faker = new Faker();
        return Stream.of(
                Arguments.of(faker.name().firstName(), faker.name().lastName(),
                        faker.internet().emailAddress(), faker.address().fullAddress()),
                Arguments.of(faker.name().firstName(), faker.name().lastName(),
                        faker.internet().emailAddress(), faker.address().fullAddress())
        );
    }

    @MethodSource("validFormData")
    @ParameterizedTest(name = "Полная форма: {0} {1}")
    void practiceFormSuccessTest(String firstName, String lastName, String email, String address) {
        Faker faker = new Faker();
        String phone = faker.number().digits(10);
        String gender = getRandomItemFromList(GENDERS);
        String subject = getRandomItemFromList(SUBJECTS);
        String hobby = getRandomItemFromList(HOBBIES);
        List<String> stateCity = getRandomItemFromList(STATE_CITIES);
        String state = stateCity.get(0);
        String city = stateCity.get(1);
        LocalDate birthDate = faker.timeAndDate().birthday();
        int birthDay = birthDate.getDayOfMonth();
        String birthMonth = birthDate.getMonth().getDisplayName(
                TextStyle.FULL, Locale.ENGLISH);
        String birthYear = String.valueOf(birthDate.getYear());
        String formattedBirthDate = birthDate.format(
                DateTimeFormatter.ofPattern("d MMMM,yyyy", Locale.ENGLISH));

        practiceFormPage.open()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(PICTURE)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        practiceFormPage.checkModalTitle(SUBMIT_TITLE);
        assertEquals(firstName + " " + lastName, practiceFormPage.getResult("Student Name"));
        assertEquals(email, practiceFormPage.getResult("Student Email"));
        assertEquals(gender, practiceFormPage.getResult("Gender"));
        assertEquals(phone, practiceFormPage.getResult("Mobile"));
        assertEquals(formattedBirthDate, practiceFormPage.getResult("Date of Birth"));
        assertEquals(subject, practiceFormPage.getResult("Subjects"));
        assertEquals(hobby, practiceFormPage.getResult("Hobbies"));
        assertEquals(PICTURE, practiceFormPage.getResult("Picture"));
        assertEquals(address, practiceFormPage.getResult("Address"));
        assertEquals(state + " " + city, practiceFormPage.getResult("State and City"));
    }
}
