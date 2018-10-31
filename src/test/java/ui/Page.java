package ui;
import static com.codeborne.selenide.Selenide.open;

public abstract class Page {

    public String pageURL;

    public void openPage() {
        open(pageURL);
    }
}
