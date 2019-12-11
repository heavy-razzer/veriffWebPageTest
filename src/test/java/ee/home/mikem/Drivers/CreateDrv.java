package ee.home.mikem.Drivers;

import ee.home.mikem.Objects.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

import static ee.home.mikem.Objects.MSG.*;
import static ee.home.mikem.Utils.Log.errLog;
import static ee.home.mikem.Utils.Log.sysLog;
import static ee.home.mikem.Utils.OsUtils.*;

public class CreateDrv {

    public static WebDriver createLocalDriver() {

        WebDriver localDriver = null;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("w3c", false); // Fix for new Appium 1.15

        String browser = getBrowser();
        sysLog(CREATING_LOCAL_DRV);

        if (browser.equals(Browsers.CHROME) || browser.isEmpty()) {
            String pathToDriver = getPathToChromeDrv();
            System.setProperty("webdriver.chrome.driver", pathToDriver);
            try {
                localDriver = new ChromeDriver(options);
                localDriver.manage().window().maximize();
                localDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                sysLog(LOCAL_DRV_CREATED);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                errLog(ERR_CREATING_LOCAL_DRV);
            }
        }

        if (browser.equals(Browsers.SAFARI)) {
            try {
                localDriver = new SafariDriver();
                localDriver.manage().window().maximize();
                localDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                sysLog(LOCAL_DRV_CREATED);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                errLog(ERR_CREATING_LOCAL_DRV);
            }
        }
        return localDriver;
    }

    private static String getPathToChromeDrv() {

        String rootDirectory = System.getProperty("user.dir");
        String pathToDriver = null;

        if (isWindows()) {
            pathToDriver = rootDirectory + "\\drivers\\chromedriver.exe";
        }

        if (isMAC()) {
            pathToDriver = rootDirectory + "/drivers/chromedriver";
        }

        if (isLinux()) {
            pathToDriver = rootDirectory + "/drivers/chromedriver_linux";
        }

        if (pathToDriver == null) {
            errLog(ERR_SETTING_PATH_TO_DRV);
        }

        return pathToDriver;
    }
}
