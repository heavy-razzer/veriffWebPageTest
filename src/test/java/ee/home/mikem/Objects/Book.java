package ee.home.mikem.Objects;

import ee.home.mikem.Drivers.SleepDriver;
import ee.home.mikem.MainTest;
import ee.home.mikem.Utils.OsUtils;
import io.qameta.allure.Description;
import lombok.Getter;

@Getter
public class Book extends MainTest {

    private String title;
    private String author;
    private String summary;
    private String isbn;
    private String genre;

    public Book() {
        title = "Test book " + OsUtils.timeStamp(DateFormats.LONG);
        author = "Carroll, Lewis";
        summary = "Test summary";
        isbn = "1234567890123";
        genre = Genre.NON_FICTION;
    }

    public Book setParameters(String Title, String Author, String Summary, String Isbn, String Genre) {
        title = Title;
        author = Author;
        summary = Summary;
        isbn = Isbn;
        genre = Genre;
        return this;
    }

    @Description("Create new book entry")
    public Book createBookEntry() {

        /*
        This is very straightforward approach to creating book: from UI. It takes to many time ond not reliable.
        Much better is to use API commands or direct access to DB.
        But because I have no such access, I just copied steps from test =)
         */

        homePage
                .waitForOpening();
        mainMenu
                .selectNewBook();
        newBookPage
                .waitForOpening()
                .enterTitle(this.getTitle())
                .selectAuthor(this.getAuthor())
                .enterSummary(this.getSummary())
                .enterISBN(this.getIsbn())
                .selectBookType(this.getGenre())
                .submit();
        bookDetailsPage
                .waitForOpening();

        // I cant check if book was really created, so wait for a wile for sure
        SleepDriver.sleep(2);

        return this;
    }
}
