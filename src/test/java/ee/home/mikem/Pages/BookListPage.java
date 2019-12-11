package ee.home.mikem.Pages;

import ee.home.mikem.Drivers.SleepDriver;
import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.Colours;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static ee.home.mikem.Objects.DateFormats.SHORT_TIME;
import static ee.home.mikem.Utils.Log.log;
import static ee.home.mikem.Utils.OsUtils.timeStamp;

/*
Web page with Catalogue: books list
 */
public class BookListPage extends BasePage {

    private String TAG = "  BookListPage   ";

    public BookListPage() {
        PageFactory.initElements(MainTest.driver, this);
    }

    @FindBy(xpath = "//h1[text()='Book List']")
    private WebElement pageTitle;

    @Step("Wait for Book list page opened")
    public BookListPage waitForOpening() {
        //TODO: Looks like there is some animation on site, so actions are not applied to elements, although it is visible and clickable. Wait for something else.
        SleepDriver.sleep(1);
        waitFor(pageTitle, "Book list page title", TAG);
        return this;
    }

    @Step("Check if book '{title}' is displayed")
    public BookListPage isBookTitleListed(String title) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + TAG
                + ": Check if book '"
                + Colours.CYAN.getColour()
                + title
                + Colours.DEFAULT.getColour()
                + "' is listed");
        List<WebElement> books = MainTest.driver.findElements(By.linkText(title));
        Assert.assertFalse("Book with title '" + title + "' not listed", books.isEmpty());
        return this;
    }
}
