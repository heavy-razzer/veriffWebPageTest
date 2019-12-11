package ee.home.mikem.Pages;

import ee.home.mikem.MainTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailsPage extends BasePage {

    private String TAG = "  BookDetailsPage   ";

    public BookDetailsPage() {
        PageFactory.initElements(MainTest.driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Title:')]")
    private WebElement bookTitleLabel;

    public BookDetailsPage waitForOpening() {
        waitFor(bookTitleLabel, "Book title", TAG);
        return this;
    }
}
