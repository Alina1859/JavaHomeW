package helpers;

import java.util.List;

public class TestData {

    public static final List<String> GENDERS = List.of("Male", "Female", "Other");
    public static final List<String> SUBJECTS = List.of(
            "Maths", "Accounting", "Arts", "Social Studies", "Biology", "Chemistry",
            "Computer Science", "Commerce", "Economics", "English", "Hindi", "History",
            "Civics", "Physics"
    );
    public static final List<String> HOBBIES = List.of("Sports", "Reading", "Music");
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

    public static final String INVALID_EMAIL = "notanemail";
    public static final String INVALID_PHONE = "12345";
    public static final String UNKNOWN_SUBJECT = "UnknownSubject";

    public static final String SUBMIT_TITLE = "Thanks for submitting the form";

    public static final String ERROR_BORDER_COLOR = "rgb(220, 53, 69)";
    public static final String ERROR_TEXT_COLOR = "rgba(220, 53, 69, 1)";
}
