import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class IssueFinderSteps {
    private static final String Repo = "Drajke/hw10_allure_reports";
    private static final int Issue = 1;
    @Test
    public void stepsIssueTest()
    {
        SelenideLogger.addListener("allure", new AllureSelenide());
        utils.IssueFinderSteps steps = new utils.IssueFinderSteps();

        steps.openMainPage();
        steps.searchForRepo(Repo);
        steps.clickOnRepoLink(Repo);
        steps.openIssuesTab();
        steps.shouldHaveIssue(Issue);
    }
}
