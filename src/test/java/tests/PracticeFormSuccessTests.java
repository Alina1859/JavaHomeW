package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;

public class PracticeFormSuccessTests extends TestBase {

    @Test
    void practiceFormSuccessTest() {
        open("/automation-practice-form");

        $("#firstName").val("Don");
        $("#lastName").val("Simon");
        $("#userEmail").val("dobroipozitiv@gmail.com");
        $("#gender-radio-1").setSelected(true);
        $("#userNumber").val("89996666666");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--018").click();

        $("#subjectsInput").val("Maths")
                .pressEnter();
        $("#hobbies-checkbox-2").setSelected(true);
        $("#uploadPicture").uploadFromClasspath("dog.jpg");
        $("#currentAddress").val("Улица Пушкина, дом Колотушкина, 7");
        $("#react-select-3-input").val("NCR")
                .pressEnter();
        $("#react-select-4-input").val("Delhi")
                .pressEnter();

        executeJavaScript("document.getElementById('submit').click();");

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive")
                .shouldHave(
                        text("Don Simon"),
                        text("dobroipozitiv@gmail.com"),
                        text("Male"),
                        text("8999666666"),
                        text("18 July,1996"),
                        text("Maths"),
                        text("Reading"),
                        text("dog.jpg"),
                        text("Улица Пушкина, дом Колотушкина, 7"),
                        text("NCR Delhi"));
    }
}
