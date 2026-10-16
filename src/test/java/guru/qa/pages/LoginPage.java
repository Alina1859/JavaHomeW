package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement userNameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $("[data-test=error]");

    public LoginPage openPage() {
        open("/");
        return this;
    }

    public LoginPage login(String login, String password) {
        userNameInput.setValue(login);
        passwordInput.setValue(password);
        loginButton.click();
        return this;
    }

    public LoginPage checkErrorMessage(String expectedError) {
        errorMessage.shouldHave(text(expectedError));
        return this;
    }
}
