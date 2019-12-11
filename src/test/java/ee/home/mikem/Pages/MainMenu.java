package ee.home.mikem.Pages;

import ee.home.mikem.MainTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu extends BasePage {

    private String TAG = "  MainMenu   ";

    public MainMenu() {
        PageFactory.initElements(MainTest.driver, this);
    }

    @FindBy(xpath = "//a[@href='/catalog']")
    private WebElement homeButton;

    @FindBy(xpath = "//a[@href='/catalog/book/create']")
    private WebElement createNewBookButton;

    @FindBy(xpath = "//a[@href='/catalog/books']")
    private WebElement allBooksButton;

    @Step("Select menu command 'Home'")
    public void selectHome() {
        click(homeButton, "Home", TAG);
    }

    @Step("Select menu command 'All books'")
    public void selectAllBooks() {
        click(allBooksButton, "All books", TAG);
    }

    @Step("Select menu command 'New book'")
    public void selectNewBook() {
        click(createNewBookButton, "Create new book", TAG);
    }
}
