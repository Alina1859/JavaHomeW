package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

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

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submit.scrollTo().click();
        return this;
    }

    public String getOutputName() {
        return outputName.shouldBe(visible).getText();
    }

    public String getOutputEmail() {
        return outputEmail.shouldBe(visible).getText();
    }

    public String getOutputCurrentAddress() {
        return outputCurrentAddress.shouldBe(visible).getText();
    }

    public String getOutputPermanentAddress() {
        return outputPermanentAddress.shouldBe(visible).getText();
    }

    public String getUserEmailClass() {
        return userEmail.getAttribute("class");
    }
}
