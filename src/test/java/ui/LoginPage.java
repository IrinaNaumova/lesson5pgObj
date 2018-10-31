package ui;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public final class LoginPage extends Page {

    public LoginPage(){
        this.pageURL = "https://courier-test.esphere.ru/";
    }

    public void login(String login, String password){
        $(By.id("IDToken1")).setValue(login);
        $(By.id("IDToken2")).setValue(password);
        $(By.name("Login.Submit")).click();
    }

}

