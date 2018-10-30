package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import constants.Drivers;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.File;

import static com.codeborne.selenide.Selenide.*;

@Listeners(UiScreenshots.class)
public class UITest {

    //private static final String LKK_URL = "https://courier-test.esphere.ru/";

    @BeforeTest
    public static void setDriver() {
        System.setProperty("webdriver.chrome.driver", Drivers.CHROME);
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @Test
    public void selenideUiAuthTest() {
        //open(LKK_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.login("test_lut", "12345678");
        //loginPage.loginThis("test_lut", "12345678");

        NewDocumentPage newDocumentPage = new NewDocumentPage();
        newDocumentPage.openNewDocPage();
        newDocumentPage.selectDocType("Договор");
        newDocumentPage.setDocNumber("12345678");
        newDocumentPage.setDocReciever("КАРМЕЛЬ");
        newDocumentPage.uploadDocument("src/test/java/ui/UpFile.txt");

        //$(byText("Документ №12345678")).shouldBe(Condition.visible);
        // $(By.cssSelector("data-bind='text: document.description'")).shouldHave(Condition.exactText("Документ №12345678"));
        // shouldBe(Condition.visible);
        sleep(1000);

    }

}
