package ee.home.mikem.Libraries;

import ee.home.mikem.Drivers.CreateDrv;
import org.openqa.selenium.WebDriver;

public class DriverRoutines {

    public static WebDriver initDriver() {
        return CreateDrv.createLocalDriver();
    }

}
