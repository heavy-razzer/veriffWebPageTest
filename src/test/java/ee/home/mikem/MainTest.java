package ee.home.mikem;

import ee.home.mikem.Libraries.DriverRoutines;
import ee.home.mikem.Libraries.TestWatchers;
import ee.home.mikem.Pages.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

import static ee.home.mikem.Objects.MSG.DRV_CLOSED;
import static ee.home.mikem.Utils.Log.sysLog;

public class MainTest {

    // Link to test page
    private String HOME_PAGE = "https://raamatukogu.herokuapp.com/catalog";

    // Additional actions at test end
    @Rule
    public TestWatchers basicRules = new TestWatchers();

    // Main driver
    public static WebDriver driver;

    // Pages with screen elements locators
    protected HomePage homePage;
    protected NewBookPage newBookPage;
    protected BookDetailsPage bookDetailsPage;
    protected MainMenu mainMenu;
    protected BookListPage bookListPage;

    public MainTest() {

        // Init pages
        homePage = new HomePage();
        newBookPage = new NewBookPage();
        bookDetailsPage = new BookDetailsPage();
        mainMenu = new MainMenu();
        bookListPage = new BookListPage();
    }

    @BeforeClass
    public static void prepareSuite() {
        driver = DriverRoutines.initDriver();
    }

    @AfterClass
    public static void terminateSuite() {

        if (driver != null) {
            driver.quit();
            sysLog(DRV_CLOSED);
        }
    }

    @Before
    public void beforeTest() {
        driver.manage().deleteAllCookies();
        driver.get(HOME_PAGE);
    }
}
