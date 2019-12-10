package ee.home.mikem.Tests;

import ee.home.mikem.Drivers.SleepDriver;
import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.BookType;
import org.junit.Test;

public class SampleTest extends MainTest {

    @Test
    public void myTest() {

        homePage
                .waitForOpening()
                .clickNewButtonLink();

        SleepDriver.sleep(1);

        newBookPage
                .waitForOpening()
                .enterTitle("Title")
                .selectAuthor("Carroll, Lewis")
                .enterSummary("Summary")
                .enterISBN("1234567890123")
                .selectBookType(BookType.NON_FICTION)
                .submit();

        SleepDriver.sleep(5);
    }
}
