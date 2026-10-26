package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponent resultTable = new ResultTableComponent();

    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg");

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

    public PracticeFormPage waitForGenderColor(String gender, String color) {
        genderWrapper.$(byText(gender)).shouldHave(cssValue("color", color));
        return this;
    }

    public String getGenderColor(String gender) {
        return genderWrapper.$(byText(gender)).getCssValue("color");
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

    public PracticeFormPage setDateOfBirth(int day, String month, String year) {
        calendar.setDateOfBirth(day, month, year);
        return this;
    }

    public String getModalTitle() {
        return modalTitle.shouldBe(visible).getText();
    }

    public String getResult(String field) {
        return resultTable.getResult(field);
    }

}
