import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Kaid");
        $("#lastName").setValue("Sulimanov");
        $("#userEmail").setValue("kkaidd@mail.ru");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("9520931995");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOption("November");
        $("[class=react-datepicker__year-select]").selectOption("1990");
        $("[class~=react-datepicker__day--010]").click();
        $("#subjectsInput").setValue("English").pressEnter().setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Screen.png");
        $("#currentAddress").setValue("Город Москва, улица скворцова-спепанова, дом 15");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("[id=submit]").click();


        $("[class~=table]").shouldHave(text("Student Name")).shouldHave(text("Kaid Sulimanov"));
        $("[class~=table]").shouldHave(text("Student Email")).shouldHave(text("kkaidd@mail.ru"));
        $("[class~=table]").shouldHave(text("Gender")).shouldHave(text("Other"));
        $("[class~=table]").shouldHave(text("Mobile")).shouldHave(text("9520931995"));
        $("[class~=table]").shouldHave(text("Date of Birth")).shouldHave(text("10 November,1990"));
        $("[class~=table]").shouldHave(text("Subjects")).shouldHave(text("English, Hindi"));
        $("[class~=table]").shouldHave(text("Hobbies")).shouldHave(text("Sports"));
        $("[class~=table]").shouldHave(text("Picture")).shouldHave(text("Screen.png"));
        $("[class~=table]").shouldHave(text("Address")).shouldHave(text("Город Москва, улица скворцова-спепанова, дом 15"));
        $("[class~=table]").shouldHave(text("State and City")).shouldHave(text("NCR Delhi"));


    }
}
