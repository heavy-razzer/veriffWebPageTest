package ee.home.mikem.Pages;

import ee.home.mikem.MainTest;
import ee.home.mikem.Objects.Colours;
import ee.home.mikem.Objects.MSG;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ee.home.mikem.Objects.DateFormats.SHORT_TIME;
import static ee.home.mikem.Utils.Log.errLog;
import static ee.home.mikem.Utils.Log.log;
import static ee.home.mikem.Utils.OsUtils.timeStamp;

class BasePage {

    @Step("Click on '{description}'")
    static void click(WebElement element, String description, String tag) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + tag
                + ": Click '"
                + Colours.CYAN.getColour()
                + description
                + Colours.DEFAULT.getColour()
                + "'");
        try {
            element.click();
        } catch (WebDriverException e) {
            System.out.println(e.toString());
            errLog(MSG.ERR_CLICK_FAILED, description);
        }
    }

    @Step("Wait for element '{description}'")
    static void waitFor(WebElement element, String description, String tag) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + tag
                + ": Wait for '"
                + Colours.CYAN.getColour()
                + description
                + Colours.DEFAULT.getColour()
                + "'");
        WebDriverWait wait = new WebDriverWait(MainTest.driver, 5);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            errLog(timeStamp(SHORT_TIME)
                    + " - "
                    + tag
                    + ": Failed to wait for element appears on screen '"
                    + description
                    + "'");
        }
    }

    @Step("Type '{text}' text to element '{description}'")
    static void type(WebElement element, String text, String description, String tag) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + tag
                + ": Type '"
                + Colours.PURPLE.getColour() + text + Colours.DEFAULT.getColour()
                + "' to '"
                + Colours.CYAN.getColour() + description + Colours.DEFAULT.getColour()
                + "'");
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException e) {
            System.out.println(e.toString());
            errLog(timeStamp(SHORT_TIME)
                    + " - "
                    + tag
                    + ": Failed to insert '"
                    + text
                    + "' to '"
                    + description
                    + "'");
        }
    }

    @Step("Select '{text}' item in dropdown '{description}'")
    static void selectItemInDropDown(WebElement element, String text, String description, String tag) {
        log(Colours.BLUE.getColour() + timeStamp(SHORT_TIME) + Colours.DEFAULT.getColour()
                + " - "
                + tag
                + ": Select '"
                + Colours.PURPLE.getColour() + text + Colours.DEFAULT.getColour()
                + "' in '"
                + Colours.CYAN.getColour() + description + Colours.DEFAULT.getColour()
                + "'");
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (WebDriverException e) {
            System.out.println(e.toString());
            errLog(timeStamp(SHORT_TIME)
                    + " - "
                    + tag
                    + ": Failed to select '"
                    + text
                    + "' in '"
                    + description
                    + "'");
        }
    }
}
