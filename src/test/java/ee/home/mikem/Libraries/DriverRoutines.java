package ee.home.mikem.Libraries;

import ee.home.mikem.Drivers.CreateDrv;
import org.openqa.selenium.WebDriver;

public class DriverRoutines {

    public static WebDriver initDriver() {
        return CreateDrv.createLocalDriver();

        /*
        Now here is only one type of driver.
        But in future we can add more types, like BrowserStack or SauseLabs, or mobile connection with Appium
        One 'init' will create corresponding driver, based on run parameters (from mvn command line or config file)
         */
    }

}
