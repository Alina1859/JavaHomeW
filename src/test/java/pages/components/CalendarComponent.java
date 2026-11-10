package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement
    dateOfBirthInput = $("#dateOfBirthInput"),
    monthSelect = $(".react-datepicker__month-select"),
    yearSelect = $(".react-datepicker__year-select");

    private SelenideElement daySelect(int day) {
        String prefix = day < 10 ? "00" : "0";
        return $(".react-datepicker__day--" + prefix + day
                + ":not(.react-datepicker__day--outside-month)");
    }

    @Step("Выбираем дату рождения «{day} {month} {year}»")
    public void setDateOfBirth(int day, String month, String year) {
        dateOfBirthInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect(day).click();
    }
}
