package ee.home.mikem.Pages;

import ee.home.mikem.MainTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private String TAG = "  HomePage   ";

    public HomePage() {
        PageFactory.initElements(MainTest.driver, this);
    }

    @FindBy(xpath = "//h1[text()='Local Library Home']")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[@href='/catalog/book/create']")
    private WebElement createNewBookLink;

    @Step("Wait for Home page opened")
    public HomePage waitForOpening() {
        waitFor(pageTitle, "Page title", TAG);
        return this;
    }
}