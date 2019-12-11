package ee.home.mikem.Libraries;

import ee.home.mikem.MainTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

//=====
// This function can be used to mark elements under test, if needed.
//=====
public class Support {

    // Set pause for milliseconds
    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ie) {
            System.out.println("\n Cant make sleep to " + seconds);
        }
    }

    // Make current web-element flashing
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
}
