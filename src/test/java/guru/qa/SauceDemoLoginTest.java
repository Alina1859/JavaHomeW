package guru.qa;

import guru.qa.data.SauceUser;
import guru.qa.pages.LoginPage;
import guru.qa.pages.ProductsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("Тесты на проверку логина")
public class SauceDemoLoginTest extends TestBase {

    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Test
    @DisplayName("Пользователь с корректными данными попадает на страницу товаров")
    void validCredentialsShouldLoginUser() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce");
        productsPage.checkOpened();
    }

    @EnumSource(value = SauceUser.class, mode = EnumSource.Mode.EXCLUDE, names = "LOCKED_OUT")
    @ParameterizedTest(name = "Пользователь с логином {0} попадает на страницу товаров")
    void validExactCredentialsShouldLoginUser(SauceUser user) {
        loginPage.openPage()
                .login(user.login, "secret_sauce");
        productsPage.checkOpened();
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
        loginPage.openPage()
                .login(login, password)
                .checkErrorMessage("Username and password do not match");
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
        loginPage.openPage()
                .login(login, password)
                .checkErrorMessage(expectedError);
    }

    @CsvFileSource(resources = "/invalid_login.csv", numLinesToSkip = 1)
    @ParameterizedTest(name = "Из файла: логин «{0}», пароль «{1}» показывает ошибку «{2}»")
    void invalidDataFromFileShouldShowError(String login, String password, String expectedError) {
        loginPage.openPage()
                .login(login, password)
                .checkErrorMessage(expectedError);
    }
}

