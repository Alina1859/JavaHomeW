package helpers;

import java.util.List;
import java.util.stream.Stream;

public class TestData {

  public static final List<String> SUBJECTS = List.of(
          "Maths", "Accounting", "Arts", "Social Studies", "Biology", "Chemistry",
          "Computer Science", "Commerce", "Economics", "English", "Hindi", "History",
          "Civics", "Physics"
  );
  public static final List<String> HOBBIES = List.of("Sports", "Reading", "Music");
  public static final List<String> GENDERS = List.of("Male", "Female", "Other");
  public static final List<List<String>> STATE_CITIES = List.of(
          List.of("NCR", "Delhi"),
          List.of("NCR", "Gurgaon"),
          List.of("NCR", "Noida"),
          List.of("Uttar Pradesh", "Agra"),
          List.of("Uttar Pradesh", "Lucknow"),
          List.of("Uttar Pradesh", "Merrut"),
          List.of("Haryana", "Karnal"),
          List.of("Haryana", "Panipat"),
          List.of("Rajasthan", "Jaipur"),
          List.of("Rajasthan", "Jaiselmer"),
          List.of("Rajasthan", "Udaipur")
  );
  public static final String PICTURE = "dog.jpg";

  public static Stream<String> genders() {
    return GENDERS.stream();
  }

  public static final List<String> INVALID_EMAILS = List.of(
          "notanemail",
          "user@",
          "@example.com"
  );

  public static Stream<String> invalidEmails() {
    return INVALID_EMAILS.stream();
  }

  public static final List<String> INVALID_PHONES = List.of(
          "1",
          "12345",
          "123456789"
  );

  public static Stream<String> invalidPhones() {
    return INVALID_PHONES.stream();
  }

  public static final String UNKNOWN_SUBJECT_CYRILLIC = "КвантоваяФизика";
  public static final String UNKNOWN_SUBJECT_LATIN = "UnknownSubject";

  public static final String SUBMIT_TITLE = "Thanks for submitting the form";
}
