package ee.home.mikem.Pages;

import ee.home.mikem.MainTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu extends BasePage {

    private String TAG = "  NewBookPage   ";

    public MainMenu() {
        PageFactory.initElements(MainTest.driver, this);
    }

    @FindBy(xpath = "//a[@href='/catalog']")
    private WebElement homeButton;

    @FindBy(xpath = "//a[@href='/catalog/book/create']")
    private WebElement createNewBookButton;

    public void selectHome() {
        click(homeButton, "Home", TAG);
    }

    public void selectNewBook() {
        click(createNewBookButton, "Create new book", TAG);
    }
}
