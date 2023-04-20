package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectPage extends BasePage {
    @Step("Opening Login Page")
    public void openPP() {
        log.info("Opening Project Page");
        open("/projects");
    }

    public void isPageOpened() {
        $("#btnLogin").shouldBe(Condition.visible);
    }

}

