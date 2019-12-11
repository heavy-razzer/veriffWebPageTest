package ee.home.mikem.Pages;

import ee.home.mikem.MainTest;
import io.qameta.allure.Step;
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

    @Step("Wait for Book details page opened")
    public BookDetailsPage waitForOpening() {
        waitFor(bookTitleLabel, "Book title", TAG);
        return this;
    }
}
