package helpers;

import net.datafaker.Faker;
import models.RequiredFormData;
import models.TextBoxData;
import models.ValidFormData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import static helpers.TestData.GENDERS;
import static helpers.TestData.HOBBIES;
import static helpers.TestData.STATE_CITIES;
import static helpers.TestData.SUBJECTS;

public class DataGenerator {
    private static final Faker FAKER = new Faker();

    public static String getRandomName() {
        return FAKER.name().fullName();
    }

    public static String getRandomFirstName() {
        return FAKER.name().firstName();
    }

    public static String getRandomLastName() {
        return FAKER.name().lastName();
    }

    public static String getRandomEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String getRandomGender() {
        return FAKER.options().nextElement(GENDERS);
    }

    public static String getRandomSubject() {
        return FAKER.options().nextElement(SUBJECTS);
    }

    public static String getRandomHobby() {
        return FAKER.options().nextElement(HOBBIES);
    }

    public static String getRandomCurrentAddress() {
        return FAKER.address().streetAddress();
    }

    public static String getRandomPermanentAddress() {
        return FAKER.address().streetAddress();
    }

    public static String getRandomFullAddress() {
        return FAKER.address().fullAddress();
    }

    public static String getRandomPhone() {
        return FAKER.number().digits(10);
    }

    public static LocalDate getRandomBirthDate() {
        return FAKER.timeAndDate().birthday();
    }

    public static TextBoxData randomTextBoxData() {
        return randomTextBoxData(getRandomEmail());
    }

    public static TextBoxData randomTextBoxData(String email) {
        return new TextBoxData(
                getRandomName(),
                email,
                getRandomCurrentAddress(),
                getRandomPermanentAddress()
        );
    }

    public static RequiredFormData randomRequiredFormData() {
        return new RequiredFormData(
                getRandomFirstName(),
                getRandomLastName(),
                getRandomGender(),
                getRandomPhone()
        );
    }

    public static ValidFormData randomValidFormData() {
        List<String> stateCity = FAKER.options().nextElement(STATE_CITIES);
        LocalDate birthDate = getRandomBirthDate();

        return new ValidFormData(
                getRandomFirstName(),
                getRandomLastName(),
                getRandomEmail(),
                getRandomFullAddress(),
                getRandomPhone(),
                getRandomGender(),
                birthDate.getDayOfMonth(),
                birthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                String.valueOf(birthDate.getYear()),
                birthDate.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH)),
                getRandomSubject(),
                getRandomHobby(),
                stateCity.get(0),
                stateCity.get(1)
        );
    }
}
