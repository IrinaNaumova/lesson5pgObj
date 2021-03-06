package ui;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewDocumentPage extends Page{

    public NewDocumentPage(){
        this.pageURL = "https://courier-test.esphere.ru/document/new";
    }

    public void selectDocType(String documentType){
        $(byText("(выберите)")).click();
        $$(By.className("k-item")).find(Condition.exactText(documentType)).hover().click();
    }

    public void setDocNumber(String number){
        $(By.id("number")).setValue(number);
    }

    public void setDocReciever(String resiver){
        $(byText("Введите ИНН/Наименование")).click();
        $("#receiver-id-list span input.k-textbox").shouldBe(Condition.visible).setValue(resiver);
        $(By.id("receiver-id_listbox")).shouldBe(Condition.visible);
        $(withText(resiver)).hover().click();
    }

    public void uploadDocument(String filePath) {
        $(By.id("fileDocument")).uploadFile(new File(filePath));
        $(By.id("progressText")).waitUntil(Condition.hidden, 30000);
        $(By.linkText("Сохранить")).click();

    }

}
