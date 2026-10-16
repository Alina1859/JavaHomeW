package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    private final SelenideElement title = $(".title");
    private final SelenideElement cartContainer = $("#shopping_cart_container");

    public ProductsPage checkOpened() {
        title.shouldHave(text("Products"));
        cartContainer.shouldBe(visible);
        return this;
    }
}
