import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueFinderLambda {
    private static final String Repo = "Drajke/hw10_allure_reports";
    private static final int Issue = 1;
    @Test
    public void lambdaIssueTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
                    open("https://github.com");
                });
        step("Пишем " + Repo + " в строке поиска и жмем Enter", () -> {
                    $(".header-search-input").click();
                    $(".header-search-input").sendKeys(Repo);
                    $(".header-search-input").submit();
                });

        step("Кликаем по ссылке репозитория", () -> {
                    $(linkText(Repo)).click();
                });

        step("Открываем вкладку Issues", () -> {
                    $("#issues-tab").click();
                });

        step("Проверяем наличие Issue с номером " + Issue, () -> {
                    $(withText("#" + Issue)).should(Condition.exist);
                });
    }
}
