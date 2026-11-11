package tests;

import helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@DisplayName("Демо: падающий тест для проверки вложений в Allure")
public class FailingDemoTest extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @DisplayName("Проверяем текст, которого нет на странице")
    void intentionallyFailingTest() {
        step("Открываем страницу Text Box", () ->
                textBoxPage.open());

        step("Проверяем текст, которого нет (здесь тест упадёт)", () ->
                $("#output #name").shouldHave(text("Этого текста на странице никогда не было")));
    }
}
