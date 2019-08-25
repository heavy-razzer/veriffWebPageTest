package ee.home.mikem.Pages;

import ee.home.mikem.Libraries.Support;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void checkPageIsOpened(){

        Assert.assertTrue("Landing page not opened", Support.waitForVisibility(pageHeader));
    }

    public void verificationOptionShouldBeEnabled(String option){

        Assert.assertTrue("Option '"+option+"' is not enabled",
                Support.waitForVisibility(
                        driver.findElement(By.xpath("//div[@class='label']")).findElement(By.xpath("//*[contains(text(), '"+option+"')]"))
                )
        );
        Support.flash(driver.findElement(By.xpath("//div[@class='label']")).findElement(By.xpath("//*[text()='"+option+"']")));
    }

    public void tapStartButton(){

        Assert.assertTrue("Start button is not displayed", startButton.isDisplayed());
        Support.flash(startButton);
        startButton.click();
    }
}
