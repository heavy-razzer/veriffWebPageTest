package ee.home.mikem.Pages;

import ee.home.mikem.Libraries.Support;
import ee.home.mikem.Objects.DocumentType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GetVerifiedPage {

    private WebDriver driver;

    public GetVerifiedPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page header section
    @FindBy(xpath = "//div[@class='title']")
    private WebElement pageHeader;

    // Start button
    @FindBy(xpath = "//button[@class='button au-target']")
    private WebElement startButton;

    // Country selector
    @FindBy(xpath = "//select[@class='country-list au-target']")
    private WebElement drpCountrySelector;

    public void checkPageIsOpened(){

        Assert.assertTrue("Landing page not opened", Support.waitForVisibility(pageHeader));
    }

    public void verificationOptionShouldBeEnabled(String option, boolean isVisible){

        List<WebElement> elements = driver.findElements(By.xpath("//label[@data-test-document-type='"+ DocumentType.getTypeCode(option) +"']"));
        Assert.assertEquals(option+" option visibility should be: "+isVisible, isVisible, !elements.isEmpty());
        if (isVisible) {
            Support.flash(elements.get(0));
        }
    }

    public void tapStartButton(){

        Assert.assertTrue("Start button is not displayed", startButton.isDisplayed());
        Support.flash(startButton);
        startButton.click();
    }

    public void selectDocumentCountry(String documentCountry){

        Assert.assertTrue("Document country drop down is not visible", drpCountrySelector.isDisplayed());
        Support.flash(drpCountrySelector);
        Select drpDocumentCountry = new Select(this.drpCountrySelector);
        drpDocumentCountry.selectByVisibleText(documentCountry);
    }
}
