package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.ITestContext;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectSteps {
    LoginPage loginPage;
    NewProjectPage newProjectPage;
    ProjectPage projectPage;

    @Before
    public void setUp() {
        Configuration.timeout = 4000;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://app.qase.io";

        //loginPage = new LoginPage();
        //newProjectPage = new NewProjectPage();

    }

    @Given("user {string} logs using password {string}")
    public void userLogsUsingPassword(String user, String password) {
        loginPage.openLP();
        loginPage.isPageOpened();
        loginPage.login();
        $("#createButton").shouldBe(Condition.visible);

    }
    @When("user creates project with the following data: {string}, {string}, {string}, {string}")
    public void userCreatesProjectWithTheFollowingData(String projectName,
                                                       String projectCode,
                                                       String description,
                                                       String publicRadio) {

    }

    @And("user goes to project details page using code {string}")
    public void userGoesToProjectDetailsPageUsingCode(String projectCode) {
        open(String.format("/project/%s/settings/general", projectCode));

    }

    @Then("project page is opened with {string}, {string}, {string}, {string}")
    public void projectPageIsOpenedWith(String projectName,
                                        String projectCode,
                                        String description,
                                        String publicRadio) {
        // TODO check all fields
    }
}
