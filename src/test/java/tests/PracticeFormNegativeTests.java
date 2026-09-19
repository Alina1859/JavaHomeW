package tests;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.Test;

public class PracticeFormNegativeTests extends TestBase {

    @Test
    void practiceFormRequiredNotFilledTest() {
        open("/automation-practice-form");

        $("#submit").scrollTo().click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        $("#genterWrapper").$(byText("Male")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
    }

    @Test
    void practiceFormNotValidMobile() {
        open("/automation-practice-form");

        $("#firstName").setValue("Don");
        $("#lastName").setValue("Simon");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").clear();

        $("#submit").scrollTo().click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }


    @Test
    void practiceFormInvalidEmail() {
        open("/automation-practice-form");

        $("#firstName").setValue("Абоба");
        $("#lastName").setValue("Абобович");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999666666");

        $("#userEmail").setValue("notanemail");

        $("#submit").scrollTo().click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void practiceFormUnknownSubject() {
        open("/automation-practice-form");

        $("#firstName").setValue("Артемий");
        $("#lastName").setValue("Бурах");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999666666");

        $("#subjectsInput").setValue("КвантоваяФизика").pressEnter();

        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Артемий Бурах"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999666666"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("КвантоваяФизика"));

    }
}