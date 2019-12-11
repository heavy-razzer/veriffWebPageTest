package ee.home.mikem.Pages;

import ee.home.mikem.MainTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private String TAG = "  HomePage   ";

    public HomePage() {
        PageFactory.initElements(MainTest.driver, this);
    }

    @FindBy(className = "col-sm-10")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[@href='/catalog/book/create']")
    private WebElement createNewBookLink;

    public HomePage waitForOpening() {
        waitFor(pageTitle, "Page title", TAG);
        return this;
    }

    public HomePage clickNewButtonLink() {
        click(createNewBookLink, "Create new Book link", TAG);
        return this;
    }
}