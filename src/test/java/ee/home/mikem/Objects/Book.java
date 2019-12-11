package ee.home.mikem.Objects;

import ee.home.mikem.Utils.OsUtils;
import lombok.Getter;

@Getter
public class Book {

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
}
