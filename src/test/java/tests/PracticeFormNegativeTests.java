package tests;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;

public class PracticeFormNegativeTests extends TestBase {

    @Test
    void practiceFormRequiredNotFilledTest() {
        open("/automation-practice-form");

        executeJavaScript("document.getElementById('submit').click();");

        $("#firstName").shouldHave(cssValue("border-color",
                "rgb(220, 53, 69)"));
        $("#lastName").shouldHave(cssValue("border-color",
                "rgb(220, 53, 69)"));
        $("#userNumber").shouldHave(cssValue("border-color",
                "rgb(220, 53, 69)"));

        $("label[for='gender-radio-1']").shouldHave(cssValue("color",
                "rgba(220, 53, 69, 1)"));
    }

    @Test
    void practiceFormNotValidMobile() {
        open("/automation-practice-form");

        $("#firstName").val("Don");
        $("#lastName").val("Simon");
        $("#gender-radio-1").setSelected(true);
        $("#userNumber").val("1");

        executeJavaScript("document.getElementById('submit').click();");

        $("#userNumber").shouldHave(cssValue("box-shadow",
                "rgba(220, 53, 69, 0.25) 0px 0px 0px 4px"));
    }

    @Test
    void practiceFormInvalidEmail() {
        open("/automation-practice-form");

        $("#firstName").val("Абоба");
        $("#lastName").val("Абобович");
        $("#gender-radio-1").setSelected(true);
        $("#userNumber").val("8999666666");

        $("#userEmail").val("notanemail");

        executeJavaScript("document.getElementById('submit').click();");

        $("#userEmail").shouldHave(cssValue("box-shadow",
                "rgba(220, 53, 69, 0.25) 0px 0px 0px 4px"));
    }

    @Test
    void practiceFormUnknownSubject() {
        open("/automation-practice-form");

        $("#firstName").val("Артемий");
        $("#lastName").val("Бурах");
        $("#gender-radio-1").setSelected(true);
        $("#userNumber").val("8999666666");

        $("#subjectsInput").val("КвантоваяФизика");
        $("#subjectsInput").pressEnter();

        executeJavaScript("document.getElementById('submit').click();");

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Артемий Бурах"),
                text("Male"),
                text("8999666666"),
                text("КвантоваяФизика"));

    }
}