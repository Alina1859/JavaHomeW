package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;

public class PracticeFormRequiredOnlyTests extends TestBase {

    @Test
    void practiceFormRequiredOnlyTest() {
        open("/automation-practice-form");

        $("#firstName").val("Don");
        $("#lastName").val("Simon");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").val("89996666666");

        executeJavaScript("document.getElementById('submit').click();");

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Don Simon"),
                text("Male"),
                text("8999666666"));
    }
}
