package ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private String pageUrl = "https://courier-test.esphere.ru/";

    @FindBy(id = "IDToken1")
    private WebElement login;

    @FindBy(id = "IDToken2")
    private WebElement password;

    @FindBy(name = "Login.Submit")
    private  WebElement btnSubmit;

    public void openLoginPage() {
        open(pageUrl);
    }

    public void login(String login, String password){
        $(By.id("IDToken1")).setValue(login);
        $(By.id("IDToken2")).setValue(password);
        $(By.name("Login.Submit")).click();
    }

    public void loginThis(String login, String password) {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        this.btnSubmit.click();
    }

}
