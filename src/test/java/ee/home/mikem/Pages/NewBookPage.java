package ee.home.mikem.Pages;

import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.BookType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewBookPage extends BasePage {

    private String TAG = "  NewBookPage|   ";

    public NewBookPage() {
        PageFactory.initElements(MainTest.driver, this);
    }

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

    public NewBookPage waitForOpening() {
        waitFor(titleEdit, "Title edit field", TAG);
        return this;
    }

    public NewBookPage enterTitle(String title) {
        type(titleEdit, title, "Title edit field", TAG);
        return this;
    }

    public NewBookPage selectAuthor(String author) {
        selectItemInDropDown(authorDropDown, author, "Author drop down", TAG);
        return this;
    }

    public NewBookPage enterSummary(String title) {
        type(summaryEdit, title, "Summary edit field", TAG);
        return this;
    }

    public NewBookPage enterISBN(String isbn) {
        type(isbnEdit, isbn, "ISBN13 number", TAG);
        return this;
    }

    public NewBookPage selectBookType(String type) {
        if (type.equals(BookType.NON_FICTION)) {
            click(bookTypeCheckBoxes.get(0), "Non-Fiction", TAG);
        } else {
            click(bookTypeCheckBoxes.get(1), "Fiction", TAG);
        }
        return this;
    }

    public NewBookPage submit() {
        click(submitButton, "Submit button", TAG);
        return this;
    }
}
