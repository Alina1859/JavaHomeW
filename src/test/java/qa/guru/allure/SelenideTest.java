package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    public void testIssueSearch() {
        open("https://github.com/search?q=Alina1859/JavaHomeW&type=repositories");

        $("a[href='/Alina1859/JavaHomeW']").click();
        $("[data-tab-item='issues']").click();
        $(withText("Test Issue")).should(Condition.exist);
    }
}
