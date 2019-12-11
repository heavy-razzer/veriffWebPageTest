package ee.home.mikem;

import ee.home.mikem.Libraries.DriverRoutines;
import ee.home.mikem.Libraries.Support;
import ee.home.mikem.Pages.BookDetailsPage;
import ee.home.mikem.Pages.HomePage;
import ee.home.mikem.Pages.MainMenu;
import ee.home.mikem.Pages.NewBookPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import static ee.home.mikem.Objects.MSG.DRV_CLOSED;
import static ee.home.mikem.Utils.Log.sysLog;

public class MainTest {

    // Link to tets page
    private String HOME_PAGE = "https://raamatukogu.herokuapp.com/catalog";

    // init driver
    public static WebDriver driver;

    // init my frequently used commands
    public static Support myCommands = new Support();

    // init pages with screen elements locators
    protected HomePage homePage;
    protected NewBookPage newBookPage;
    protected BookDetailsPage bookDetailsPage;
    protected MainMenu mainMenu;

    public MainTest() {

        driver.get(HOME_PAGE);

        // Init pages
        homePage = new HomePage();
        newBookPage = new NewBookPage();
        bookDetailsPage = new BookDetailsPage();
        mainMenu = new MainMenu();
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
    public void beforeClass() {
        driver.manage().deleteAllCookies();
    }
}
