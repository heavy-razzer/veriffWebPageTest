package ee.home.mikem;

import ee.home.mikem.Libraries.Support;
import ee.home.mikem.Pages.GetVerifiedPage;
import ee.home.mikem.Pages.LandingPage;
import ee.home.mikem.Pages.NoCameraPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//=====
// Tests for "BetPawa" web site
//=====
public class MainTest {

    // init driver
    public static WebDriver driver;

    // init my frequently used commands
    public static Support myCommands = new Support();

    // init pages with screen elements locators
    protected LandingPage landingPage;
    protected GetVerifiedPage getVerifiedPage;
    protected NoCameraPage noCameraPage;

    public MainTest(){

        // Set driver for Chrome
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String landingPageLink = "https://demo.veriff.me/";
        driver.get(landingPageLink);

        // Init pages
        landingPage = new LandingPage(driver);
        getVerifiedPage = new GetVerifiedPage(driver);
        noCameraPage = new NoCameraPage(driver);
    }

    @AfterClass
    public static void tearDown() {

        driver.quit();
    }
}
