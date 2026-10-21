package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {
    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive"),
            resultTableStudentName = resultTable.$(byText("Student Name")),
            resultTableGender = resultTable.$(byText("Gender")),
            resultTableMobile = resultTable.$(byText("Mobile")),
            resultTableSubjects = resultTable.$(byText("Subjects")),
            resultTableStudentEmail = resultTable.$(byText("Student Email")),
            resultTableDateOfBirth = resultTable.$(byText("Date of Birth")),
            resultTableHobbies = resultTable.$(byText("Hobbies")),
            resultTablePicture = resultTable.$(byText("Picture")),
            resultTableAddress = resultTable.$(byText("Address")),
            resultTableStateAndCity = resultTable.$(byText("State and City"));

    private SelenideElement daySelect(int day) {
        String prefix = day < 10 ? "00" : "0";
        return $(".react-datepicker__day--" + prefix + day
                + ":not(.react-datepicker__day--outside-month)");
    }

    public PracticeFormPage open() {
        Selenide.open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage submit() {
        submit.scrollTo().click();
        return this;
    }

    public PracticeFormPage checkFirstNameBorderColor(String color) {
        firstName.shouldHave(cssValue("border-color", color));
        return this;
    }

    public PracticeFormPage checkLastNameBorderColor(String color) {
        lastName.shouldHave(cssValue("border-color", color));
        return this;
    }

    public PracticeFormPage checkUserNumberBorderColor(String color) {
        userNumber.shouldHave(cssValue("border-color", color));
        return this;
    }

    public PracticeFormPage checkUserEmailBorderColor(String color) {
        userEmail.shouldHave(cssValue("border-color", color));
        return this;
    }

    public PracticeFormPage checkGenderColor(String gender, String color) {
        genderWrapper.$(byText(gender)).shouldHave(cssValue("color", color));
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage typeSubject(String value) {
        subjectsInput.setValue(value).pressTab();
        return this;
    }

    public PracticeFormPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public String getModalTitle() {
        return modalTitle.shouldBe(visible).getText();
    }

    public String getResutTableStudentName() {
        return resultTableStudentName.sibling(0).getText();
    }

    public String getResutTableGender() {
        return resultTableGender.sibling(0).getText();
    }

    public String getResutTableMobile() {
        return resultTableMobile.sibling(0).getText();
    }

    public String getResutTableSubjects() {
        return resultTableSubjects.sibling(0).getText();
    }

    public String getResutTableStudentEmail() {
        return resultTableStudentEmail.sibling(0).getText();
    }

    public String getResutTableDateOfBirth() {
        return resultTableDateOfBirth.sibling(0).getText();
    }

    public String getResutTableHobbies() {
        return resultTableHobbies.sibling(0).getText();
    }

    public String getResutTablePicture() {
        return resultTablePicture.sibling(0).getText();
    }

    public String getResutTableAddress() {
        return resultTableAddress.sibling(0).getText();
    }

    public String getResutTableStateAndCity() {
        return resultTableStateAndCity.sibling(0).getText();
    }

    public PracticeFormPage setDateOfBirth(int day, String month, String year) {
        dateOfBirthInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect(day).click();
        return this;
    }
}
