package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    public void testIssueSearch() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Alina1859/JavaHomeW");
        $(".header-search-input").submit();

        $(linkText("Alina1859/JavaHomeW")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
