package ee.home.mikem.Pages;

import ee.home.mikem.Drivers.SleepDriver;
import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.Genre;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewBookPage extends BasePage {

    private String TAG = "  NewBookPage   ";

    public NewBookPage() {
        PageFactory.initElements(MainTest.driver, this);
    }

    @FindBy(xpath = "//h1[text()='Create Book']")
    private WebElement pageTitle;

    @FindBy(id = "title")
    private WebElement titleEdit;

    @FindBy(id = "author")
    private WebElement authorDropDown;

    @FindBy(id = "summary")
    private WebElement summaryEdit;

    @FindBy(id = "isbn")
    private WebElement isbnEdit;

    @FindBy(className = "checkbox-input")
    private List<WebElement> bookTypeCheckBoxes;

    @FindBy(className = "btn-primary")
    private WebElement submitButton;

    @Step("Wait for New book page opened")
    public NewBookPage waitForOpening() {
        SleepDriver.sleep(1);
        waitFor(pageTitle, "Create book page title", TAG);
        return this;
    }

    @Step("Enter book title '{title}'")
    public NewBookPage enterTitle(String title) {
        type(titleEdit, title, "Title edit field", TAG);
        return this;
    }

    @Step("Select book author '{author}'")
    public NewBookPage selectAuthor(String author) {
        selectItemInDropDown(authorDropDown, author, "Author drop down", TAG);
        return this;
    }

    @Step("Enter book summary '{summary}'")
    public NewBookPage enterSummary(String summary) {
        type(summaryEdit, summary, "Summary edit field", TAG);
        return this;
    }

    @Step("Enter book ISBN '{isbn}'")
    public NewBookPage enterISBN(String isbn) {
        type(isbnEdit, isbn, "ISBN13 number", TAG);
        return this;
    }

    @Step("Set book genre to '{type}'")
    public NewBookPage selectBookType(String type) {
        if (type.equals(Genre.NON_FICTION)) {
            click(bookTypeCheckBoxes.get(0), "Non-Fiction", TAG);
        } else {
            click(bookTypeCheckBoxes.get(1), "Fiction", TAG);
        }
        return this;
    }

    @Step("Click 'Submit' button")
    public NewBookPage submit() {
        click(submitButton, "Submit button", TAG);
        return this;
    }
}
