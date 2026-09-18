package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeTextBoxTests extends TestBase {

    @Test
    void textBoxMinimalFill() {
        open("/text-box");

        $("#userName").val("Don Simon");
        $("#userEmail").val("dobroipozitiv@gmail.com");
        $("#currentAddress").val("Улица Пушкина");
        $("#permanentAddress").val("Улица Колотушкина");

        executeJavaScript("document.getElementById('submit').click();");

        $("#output").shouldHave(
                text("Don Simon"),
                text("dobroipozitiv@gmail.com"),
                text("Улица Пушкина"),
                text("Улица Колотушкина"));
    }

    @Test
    void textBoxInvalidEmailIsRejected() {
        open("/text-box");

        $("#userName").val("Don Simon");
        $("#userEmail").val("notanemail");
        $("#currentAddress").val("Улица Пушкина");
        $("#permanentAddress").val("Улица Колотушкина");

        executeJavaScript("document.getElementById('submit').click();");

        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}
