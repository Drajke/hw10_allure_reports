package utils;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueFinderSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Пишем {repo} в строке поиска и жмем Enter")
    public void searchForRepo(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }
    @Step("Кликаем по ссылке репозитория")
    public void clickOnRepoLink(String repo){
        $(linkText(repo)).click();
    }
    @Step("Открываем вкладку Issues")
    public void openIssuesTab(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldHaveIssue(int issue){
        $(withText("#" + issue)).should(Condition.exist);
    }
}
