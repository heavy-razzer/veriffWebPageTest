package ee.home.mikem.Tests;

import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.Book;
import ee.home.mikem.Objects.Colours;
import ee.home.mikem.Objects.Genre;
import ee.home.mikem.Utils.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;

@Epic("Book management")
public class SampleTest extends MainTest {

    @Test
    @Description("Add new book to catalogue")
    @Severity(SeverityLevel.CRITICAL)
    public void addBook() {

        Log.print("Add new book to catalogue", Colours.CYAN);

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
        /*
        I does not check for book details on this page: this is another test.
        I check if user can ADD book, not VIEW book details
        This functionality does not linked - you can view books, even you cant create new ones, and vice versa
         */
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify newly added book is listed in catalogue")
    public void verifyNewBookListedInCatalogue() {

        Log.print("Verify newly added book is listed in catalogue", Colours.CYAN);

        Book book = new Book().createBookEntry();

        mainMenu
                .selectAllBooks();
        bookListPage
                .waitForOpening()
                .isBookTitleListed(book.getTitle());
        /*
        Here is check if title of new book is listed
        I dont check if book displayed correctly: link, author name, position etc.
         */
    }
}
