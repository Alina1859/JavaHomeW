package models;

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
