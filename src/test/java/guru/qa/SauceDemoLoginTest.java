package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Тесты на проверку логина")
public class SauceDemoLoginTest extends TestBase {

    @BeforeEach
    void setUp() {
        open("/");
    }

    @Test
    @DisplayName("Пользователь с корректными данными попадает на страницу товаров")
    void validCredentialsShouldLoginUser() {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $(".title").shouldHave(text("Products"));
        $("#shopping_cart_container").shouldBe(visible);
    }

    public enum SauceUser {
        STANDARD("standard_user"),
        PROBLEM("problem_user"),
        PERFORMANCE_GLITCH("performance_glitch_user"),
        ERROR("error_user"),
        VISUAL("visual_user"),
        LOCKED_OUT("locked_out_user");

        public final String login;

        SauceUser(String login) {
            this.login = login;
        }
    }

    @EnumSource(value = SauceUser.class, mode = EnumSource.Mode.EXCLUDE, names = "LOCKED_OUT")
    @ParameterizedTest(name = "Пользователь с логином {0} попадает на страницу товаров")
    void validExactCredentialsShouldLoginUser(SauceUser user) {
        $("#user-name").setValue(user.login);
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $(".title").shouldHave(text("Products"));
        $("#shopping_cart_container").shouldBe(visible);
    }

    @CsvSource(value = {
            "standard_user, secret_sauce_",
            "problem_user, secretsauce",
            "performance_glitch_user, 0secret_sauce",
            "error_user, _secret_sauce",
            "visual_user, 'secret_sauce '"
    })
    @ParameterizedTest(name = "Логин {0} с неверным паролем «{1}» не входит")
    void wrongPasswordShouldShowError(String login, String password) {
        $("#user-name").setValue(login);
        $("#password").setValue(password);
        $("#login-button").click();

        $("[data-test=error]").shouldHave(text("Username and password do not match"));
    }

    static Stream<Arguments> invalidLoginData() {
        return Stream.of(
                Arguments.of("locked_out_user", "secret_sauce", "Sorry, this user has been locked out"),
                Arguments.of("standard_user", "wrong_password", "Username and password do not match"),
                Arguments.of("unknown_user", "secret_sauce", "Username and password do not match"),
                Arguments.of("", "secret_sauce", "Username is required"),
                Arguments.of("standard_user", "", "Password is required")
        );
    }

    @MethodSource("invalidLoginData")
    @ParameterizedTest(name = "Логин «{0}», пароль «{1}» показывает ошибку «{2}»")
    void invalidDataShouldShowError(String login, String password, String expectedError) {
        $("#user-name").setValue(login);
        $("#password").setValue(password);
        $("#login-button").click();

        $("[data-test=error]").shouldHave(text(expectedError));
    }

    @CsvFileSource(resources = "/invalid_login.csv", numLinesToSkip = 1)
    @ParameterizedTest(name = "Из файла: логин «{0}», пароль «{1}» показывает ошибку «{2}»")
    void invalidDataFromFileShouldShowError(String login, String password, String expectedError) {
        $("#user-name").setValue(login);
        $("#password").setValue(password);
        $("#login-button").click();

        $("[data-test=error]").shouldHave(text(expectedError));
    }
}

