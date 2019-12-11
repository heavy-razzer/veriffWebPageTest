package ee.home.mikem.Tests;

import ee.home.mikem.Drivers.SleepDriver;
import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.Genre;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;

@Epic("Book management")
public class SampleTest extends MainTest {

    @Test
    @Description("Add new book by UI")
    @Severity(SeverityLevel.CRITICAL)
    public void addBook() {

        homePage
                .waitForOpening();
        mainMenu
                .selectNewBook();

        newBookPage
                .waitForOpening()
                .enterTitle("Title")
                .selectAuthor("Carroll, Lewis")
                .enterSummary("Summary")
                .enterISBN("1234567890123")
                .selectBookType(Genre.NON_FICTION)
                .submit();

        bookDetailsPage
                .waitForOpening();

        SleepDriver.sleep(5);
    }
}
