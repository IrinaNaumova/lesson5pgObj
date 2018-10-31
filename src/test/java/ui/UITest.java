package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import constants.Drivers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

@Listeners(UiScreenshots.class)
public class UITest {

    @BeforeTest
    public static void setDriver() {
        System.setProperty("webdriver.chrome.driver", Drivers.CHROME);
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @Test
    public void selenideUiAuthTest() {

        String userLogin = "test_lut";
        String userPassword = "12345678";
        String docType = "Договор";
        String docNumber = "12345678";
        String docReceiver = "КАРМЕЛЬ";
        String pathToDocFile = "src/test/java/ui/UpFile.txt";

        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.login(userLogin, userPassword);

        NewDocumentPage newDocumentPage = new NewDocumentPage();
        newDocumentPage.openPage();
        newDocumentPage.selectDocType(docType);
        newDocumentPage.setDocNumber(docNumber);
        newDocumentPage.setDocReciever(docReceiver);
        newDocumentPage.uploadDocument(pathToDocFile);

        $(withText(docType+ " №" + docNumber)).shouldBe(Condition.exist);

    }

}
