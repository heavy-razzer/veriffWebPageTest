package ee.home.mikem.Utils;

import ee.home.mikem.Objects.Browsers;
import ee.home.mikem.Objects.MSG;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ee.home.mikem.Utils.Log.sysLog;

public class OsUtils {

    private static String OS = null;
    private static String browser = null;

    private static String getOsName() {

        if (OS == null) {
            OS = System.getProperty("os.name");
            sysLog(MSG.RUNNING_ON, OS);
        }
        return OS.toLowerCase();
    }

    public static boolean isMAC() {
        return getOsName().contains("mac");
    }

    public static boolean isLinux() {
        return getOsName().contains("linux");
    }

    public static boolean isWindows() {
        return getOsName().contains("windows");
    }

    public static String getBrowser() {

        if (browser == null) {
            String browserKey = System.getProperty("browser");
            if (browserKey != null) {
                if (Browsers.checkIfStringIsBrowser(browserKey)) {
                    browser = browserKey.substring(0, 1).toUpperCase() + browserKey.substring(1);
                    sysLog(MSG.BROWSER_IS_SET, browser);
                } else {
                    Log.sysLog(MSG.ERR_INCORRECT_BROWSER_NAME);
                    browser = "";
                }
            } else {
                sysLog(MSG.BROWSER_NOT_SET);
                browser = "";
            }
        }
        return browser;
    }

    public static String timeStamp(String format) {

        DateFormat dateFormat = new SimpleDateFormat(format);
        Date newDate = new Date();
        return dateFormat.format(newDate);
    }
}
