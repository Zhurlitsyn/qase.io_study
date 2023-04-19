package tests;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginTest extends BaseTest {
    @Test(description = "Try login user")
    public void login() {
        log.info("Try login user");
        loginPage.openLP();
        loginPage.isPageOpened();
        loginPage.login();


        /*open("/login");
        $("#inputEmail").setValue("6131755@gmail.com");
        $("#inputPassword").setValue("testtest23");
        $("#btnLogin").click();
        $("#createButton").shouldBe(Condition.visible);*/
    }
}
