package helpers;

import net.datafaker.Faker;
import org.junit.jupiter.params.provider.Arguments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static helpers.TestData.GENDERS;
import static helpers.TestData.HOBBIES;
import static helpers.TestData.STATE_CITIES;
import static helpers.TestData.SUBJECTS;
import static utils.RandomUtils.getRandomItemFromList;

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

    private static TextBoxData randomTextBoxData(String email) {
        return new TextBoxData(
                getRandomName(),
                email,
                getRandomCurrentAddress(),
                getRandomPermanentAddress()
        );
    }

    public static Stream<TextBoxData> invalidTextBoxEmailData() {
        return TestData.INVALID_EMAILS.stream()
                .map(email -> DataGenerator.randomTextBoxData(email));
    }

    public static Stream<Arguments> validFormData() {
        return Stream.of(
                Arguments.of(randomValidFormData()),
                Arguments.of(randomValidFormData())
        );
    }

    private static ValidFormData randomValidFormData() {
        List<String> stateCity = getRandomItemFromList(STATE_CITIES);
        LocalDate birthDate = getRandomBirthDate();

        return new ValidFormData(
                getRandomFirstName(),
                getRandomLastName(),
                getRandomEmail(),
                getRandomFullAddress(),
                getRandomPhone(),
                getRandomItemFromList(GENDERS),
                birthDate.getDayOfMonth(),
                birthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                String.valueOf(birthDate.getYear()),
                birthDate.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH)),
                getRandomItemFromList(SUBJECTS),
                getRandomItemFromList(HOBBIES),
                stateCity.get(0),
                stateCity.get(1)
        );
    }

    public record ValidFormData(
            String firstName,
            String lastName,
            String email,
            String address,
            String phone,
            String gender,
            int birthDay,
            String birthMonth,
            String birthYear,
            String formattedBirthDate,
            String subject,
            String hobby,
            String state,
            String city
    ) {
    }

    public record TextBoxData(
            String name,
            String email,
            String currentAddress,
            String permanentAddress
    ) {
    }
}
