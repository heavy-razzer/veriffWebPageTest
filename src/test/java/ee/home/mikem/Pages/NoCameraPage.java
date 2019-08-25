package ee.home.mikem.Pages;

import ee.home.mikem.Libraries.Support;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoCameraPage {

    private WebDriver driver;

    public NoCameraPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Landing page title
    @FindBy(xpath = "//div[@data-test-mobile-fallback-title]")
    private WebElement pageTitle;

    public void checkPageIsOpened(){

        Assert.assertTrue("Landing page not opened", Support.waitForVisibility(pageTitle));
    }
}
