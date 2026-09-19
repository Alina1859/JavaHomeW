package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;

public class PracticeFormSuccessTests extends TestBase {

    @Test
    void practiceFormSuccessTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Don");
        $("#lastName").setValue("Simon");
        $("#userEmail").setValue("dobroipozitiv@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89996666666");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--018").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("dog.jpg");
        $("#currentAddress").setValue("Улица Пушкина, дом Колотушкина, 7");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Don Simon"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("dobroipozitiv@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999666666"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("18 July,1996"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("dog.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Улица Пушкина, дом Колотушкина, 7"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
