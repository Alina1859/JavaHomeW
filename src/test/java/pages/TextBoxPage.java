package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.cssClass;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxPage {
    private final SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage open() {
        Selenide.open("/text-box");
        return this;
    }

    @Step("Вводим имя «{value}»")
    public TextBoxPage setUserName(String value) {
        userName.setValue(value);
        return this;
    }

    @Step("Вводим email «{value}»")
    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    @Step("Вводим текущий адрес «{value}»")
    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Вводим постоянный адрес «{value}»")
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    @Step("Отправляем форму")
    public TextBoxPage submit() {
        submit.scrollTo().click();
        return this;
    }

    @Step("Читаем имя из результата")
    public String getOutputName() {
        return outputName.shouldBe(visible).getText();
    }

    @Step("Читаем email из результата")
    public String getOutputEmail() {
        return outputEmail.shouldBe(visible).getText();
    }

    @Step("Читаем текущий адрес из результата")
    public String getOutputCurrentAddress() {
        return outputCurrentAddress.shouldBe(visible).getText();
    }

    @Step("Читаем постоянный адрес из результата")
    public String getOutputPermanentAddress() {
        return outputPermanentAddress.shouldBe(visible).getText();
    }

    @Step("Проверяем результат: «{expected}» = «{actual}»")
    public TextBoxPage checkResult(String expected, String actual) {
        assertEquals(expected, actual);
        return this;
    }

    @Step("Проверяем подсветку ошибки у email")
    public TextBoxPage checkUserEmailHasError() {
        userEmail.shouldHave(cssClass("field-error"));
        return this;
    }
}
