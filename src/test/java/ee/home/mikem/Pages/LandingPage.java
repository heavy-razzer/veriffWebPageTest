package ee.home.mikem.Pages;

import ee.home.mikem.Libraries.Support;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Landing page title
    @FindBy(xpath = "//h1[@class='title text-center']")
    private WebElement pageTitle;

    // Edit field for Full name
    @FindBy(id = "full_name")
    private WebElement fullName;

    // Document country dropdown
    @FindBy(name = "document_country")
    private WebElement drpDocumentCountry;

    // Document type dropdown
    @FindBy(name = "document_type")
    private WebElement drpDocumentType;

    // Submit button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement veriffMeButton;

    public void checkPageIsOpened(){

        Assert.assertTrue("Landing page not opened", Support.waitForVisibility(pageTitle));
    }

    public void enterFullName(String fullNameValue){

        Assert.assertTrue("Full name edit field is not visible", fullName.isDisplayed());
        Support.flash(fullName);
        fullName.click();
        fullName.clear();
        fullName.sendKeys(fullNameValue);
    }

    public void selectDocumentCountry(String documentCountry){

        Assert.assertTrue("Document country drop down is not visible", drpDocumentCountry.isDisplayed());
        Support.flash(drpDocumentCountry);
        Select drpDocumentCountry = new Select(this.drpDocumentCountry);
        drpDocumentCountry.selectByVisibleText(documentCountry);
    }

    public void selectDocumentType(String documentType){

        Assert.assertTrue("Document type drop down is not visible", drpDocumentType.isDisplayed());
        Support.flash(drpDocumentType);
        Select drpDocument = new Select(drpDocumentType);
        drpDocument.selectByVisibleText(documentType);
    }

    public void tapSubmit(){

        Assert.assertTrue("Veriff me button is not visible", veriffMeButton.isDisplayed());
        Support.flash(veriffMeButton);
        veriffMeButton.click();
    }
}
