package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;

public class PracticeFormRequiredOnlyTests extends TestBase {

    @Test
    void practiceFormRequiredOnlyTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Don");
        $("#lastName").setValue("Simon");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999666666");

        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Don Simon"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999666666"));
    }
}
