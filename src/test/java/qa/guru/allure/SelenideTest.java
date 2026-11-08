package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    public void testIssueSearch() {
        open("https://github.com");

        $("button[aria-label*='Search or jump to']").click();
        $("input[aria-label*='Search or jump to']").sendKeys("Alina1859/JavaHomeW");
        $("input[aria-label*='Search or jump to']").pressEnter();

        $("a[href='/Alina1859/JavaHomeW']").click();
        $("[data-tab-item='issues']").click();
        $(withText("Test Issue")).should(Condition.exist);
    }
}
