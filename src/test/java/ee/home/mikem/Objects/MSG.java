package ee.home.mikem.Objects;

public enum MSG {

    // Environment names
    ENV_LOCAL("Running on local machine"),
    ENV_BS("Running on BrowserStack"),
    ENV_SL("Running on Saucelabs"),

    // Driver operations
    RUNNING_ON("Running on %s"),
    DEVICE_IS_SET("Device is set: %s / %s"),
    DESKTOP_IS_SET("Desktop platform is set: %s/%s %s/%s"),
    CREATING_LOCAL_DRV("Creating Local driver..."),
    LOCAL_DRV_CREATED("Local driver is created"),
    ERR_CREATING_LOCAL_DRV("Cannot create local WebDriver!"),
    DEVICE_NOT_SET_SETTING_UP_DT_CONN("Device not set: Setting up Desktop connection..."),
    DT_NOT_DEFINED_USE_DEFAULT("Desktop not defined: Using default Desktop parameters: Win10/Chrome"),
    BS_STARTING_DRV("Creating BrowserStack driver..."),
    BS_DRV_CREATED("BrowserStack driver is created"),
    ERR_BS_DRV_NOT_CREATED("Cannot create remote BrowserStack WebDriver!"),
    SL_STARTING_DRV("Creating SauceLabs driver..."),
    SL_DRV_CREATED("SauceLabs driver is created"),
    ERR_SL_DRV_NOT_CREATED("Cannot create remote SauceLabs WebDriver!"),
    DRV_CLOSED("Driver is closed"),
    ERR_SLEEP_FAILED("Sleep thread failed!"),
    ERR_SETTING_PATH_TO_DRV("Error setting path to driver executable!"),
    APPIUM_AUTOSTART_DISABLED("Appium autostart disabled"),
    ERR_INCORRECT_BROWSER_NAME("Incorrect browser name: Using platform default browser"),
    BROWSER_NOT_SET("Browser not set: Using platform default browser"),
    BROWSER_IS_SET("Browser is set: %s"),
    STARTING_APPIUM("Starting Appium..."),
    APPIUM_STARTED("Appium is started"),
    ERR_APPIUM_START_FAILED("Appium start failed!"),
    CLOSING_APPIUM("Closing Appium..."),
    ERR_FAILED_TO_CLOSE_APPIUM("Failed to close Appium!"),
    APPIUM_CLOSED("Appium closed"),
    APPIUM_CLOSED_FORCIBLY("Appium closed forcibly"),

    // Rules
    RULE_RESTART_TEST("Restarting test, attempt: %s"),


    // Element operations
    ERR_CLICK_FAILED("Click on element was failed: %s"),
    ERR_ELEMENT_NOT_FOUND("Element not found: %s"),

    // Element waits
    ERR_PAGE_NOT_OPENED("Home page was not loaded"),
    ERR_WAIT_FOR_ELEMENT_FAILED("Wait for element failed: %s"),
    ERR_WAIT_FOR_NOT_VISIBILe_FAILED("Wait for element not visible failed: %s");

    private String messageText;

    MSG(String message) {
        this.messageText = message;
    }

    @Override
    public String toString() {
        return messageText;
    }
}
