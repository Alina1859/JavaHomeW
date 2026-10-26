package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private final SelenideElement resultTable = $(".table-responsive");

    public String getResult(String field) {
        return resultTable.shouldBe(visible).$(byText(field)).sibling(0).getText();
    }
}
