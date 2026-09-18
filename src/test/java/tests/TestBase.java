package tests;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
  }

  @AfterEach
  void afterEach() {
    closeWebDriver();
  }
}
