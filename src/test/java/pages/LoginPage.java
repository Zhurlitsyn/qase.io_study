package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("inputEmail");
    public static final By PASSWORD_INPUT = By.id("inputPassword");
    public static final By LOGIN_BUTTON = By.id("btnLogin");

    @Step("Opening Login Page")
    public void openLP() {
        log.info("Opening Login Page");
        open(BASE_URL);
    }

    public void isPageOpened() {
        $("#btnLogin").shouldBe(Condition.visible);
    }

    @Step("Login by user")
    public void login() {
        log.info("Login by user");
        String logUser = System.getProperty("username", PropertyReader.getProperty("USERNAME"));
        String logPswrd = System.getProperty("password", PropertyReader.getProperty("PASSWORD"));
        $(USERNAME_INPUT).setValue(logUser);
        $(PASSWORD_INPUT).setValue(logPswrd);
        $(LOGIN_BUTTON).click();
    }
}

