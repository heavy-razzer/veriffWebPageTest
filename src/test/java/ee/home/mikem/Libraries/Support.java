package ee.home.mikem.Libraries;

import ee.home.mikem.MainTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//=====
// Frequently used functions for web projects
//=====
public class Support {

    //Set pause for milliseconds
    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException ie) {
            System.out.println("\n Cant make sleep to " + seconds);
        }
    }

    //Make current web-element flashing
    public static void flash(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) MainTest.driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 2; i++) {
            changeColor("red", element, js);
            changeColor(bgcolor, element, js);
        }
    }

    // Flashing function
    private static void changeColor(String color, WebElement element, JavascriptExecutor js) {
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            System.out.println("Cant change color of element");
        }
    }

    public static boolean waitForVisibility(WebElement element) {

        boolean result;
        WebDriverWait wait = new WebDriverWait(MainTest.driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
        } catch (TimeoutException e) {
            result = false;
        }
        return result;
    }
}
