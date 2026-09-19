package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeTextBoxTests extends TestBase {

    @Test
    void textBoxMinimalFill() {
        open("/text-box");

        $("#userName").setValue("Don Simon");
        $("#userEmail").setValue("dobroipozitiv@gmail.com");
        $("#currentAddress").setValue("Улица Пушкина");
        $("#permanentAddress").setValue("Улица Колотушкина");

        $("#submit").scrollTo().click();

        $("#output #name").shouldHave(text("Don Simon"));
        $("#output #email").shouldHave(text("dobroipozitiv@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Улица Пушкина"));
        $("#output #permanentAddress").shouldHave(text("Улица Колотушкина"));
    }

    @Test
    void textBoxInvalidEmailIsRejected() {
        open("/text-box");

        $("#userName").setValue("Don Simon");
        $("#userEmail").setValue("notanemail");
        $("#currentAddress").setValue("Улица Пушкина");
        $("#permanentAddress").setValue("Улица Колотушкина");

        $("#submit").scrollTo().click();

        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}
