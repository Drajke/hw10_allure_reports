import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueFinder {
    @Test
    public void simpleIssueTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Drajke/hw10_allure_reports");
        $(".header-search-input").submit();

        $(linkText("Drajke/hw10_allure_reports")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
