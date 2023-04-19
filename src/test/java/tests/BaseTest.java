package tests;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.NewProjectPage;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({TestListener.class})
public class BaseTest {
    LoginPage loginPage;
    NewProjectPage newProjectPage;
    @BeforeMethod
    public void setUp(ITestContext testContext) {
        Configuration.timeout = 4000;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://app.qase.io";

       // testContext.setAttribute("driver", getWebDriver());

        loginPage = new LoginPage();
        newProjectPage = new NewProjectPage();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
