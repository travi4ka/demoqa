import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Demoqa {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillOutForm() {
        String nameFirst = "nameFirst";
        String nameLast = "nameLast";
        String email = "hello@world.com";
        String gender = "Female";
        String phone = "1234567890";
        String subjects = "Maths";
        String hobbies = "Music";
        String pictureUrl = "ws_Hidden_Sun_&_Wheat_Field_640x960.jpg";
        String currentAddress = "currentAddress";
        String birthDateYear = "1990";
        String birthDateMonth = "October";
        String birthDateDay = "20";
        String state = "Haryana";
        String city = "Panipat";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(nameFirst);
        $("#lastName").setValue(nameLast);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-dropdown-container").click();
        $(byText(birthDateYear)).click();
        $(".react-datepicker__month-dropdown-container").click();
        $(byText(birthDateMonth)).click();
        $(".react-datepicker__day--0" + birthDateDay).click();
        $("#subjectsContainer input").setValue(subjects);
        $(".subjects-auto-complete__menu").$(byText(subjects)).click();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/" + pictureUrl));
        $("#currentAddress").setValue(currentAddress);
        $(byText("Select State")).click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("button#submit").click();

        $$(".table-responsive tr").findBy(text("Student Name" + " " + nameFirst + " " + nameLast)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Student Email" + " " + email)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Gender" + " " + gender)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Mobile" + " " + phone)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Date of Birth" + " " + birthDateDay + " " + birthDateMonth + "," + birthDateYear)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Hobbies" + " " + hobbies)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Picture" + " " + pictureUrl)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Address" + " " + currentAddress)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("State and City" + " " + state + " " + city)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Subjects" + " " + subjects)).shouldBe(visible);
    }
}