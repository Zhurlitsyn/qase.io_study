package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewProjectTest extends BaseTest {
    @Test
    public void login() {
        open("/login");
        $("#inputEmail").setValue("6131755@gmail.com");
        $("#inputPassword").setValue("testtest23");
        $("#btnLogin").click();
        $("#createButton").shouldBe(Condition.visible);
        $("#createButton").click();
        // TODO generate random name

        $("#project-name").setValue("MyFirstTest");
        // TODO generate random 10 characters
        String value = String.valueOf($("#project-code").setValue("LikeMe"));
        $("#description-area").setValue("Parameters");
        $(byText("Public")).click();
        $(byText("Create project")).click();
        $(byText("Create project")).should(Condition.disappear);
        open("/project/LIKEME/settings/general");

        $("#project-name").shouldBe(value("MyFirstTest"));
        $("#project-code").shouldHave(value("LikeMe"));
        $("#description-area").shouldHave(value("Parameters"));


    }
}
