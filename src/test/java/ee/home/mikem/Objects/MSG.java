package ee.home.mikem.Objects;

public enum MSG {

    // Driver operations
    RUNNING_ON("Running on %s"),
    CREATING_LOCAL_DRV("Creating Local driver..."),
    LOCAL_DRV_CREATED("Local driver is created"),
    ERR_CREATING_LOCAL_DRV("Cannot create local WebDriver!"),
    DRV_CLOSED("Driver is closed"),
    ERR_SLEEP_FAILED("Sleep thread failed!"),
    ERR_SETTING_PATH_TO_DRV("Error setting path to driver executable!"),
    ERR_INCORRECT_BROWSER_NAME("Incorrect browser name: Using platform default browser"),
    BROWSER_NOT_SET("Browser not set: Using platform default browser"),
    BROWSER_IS_SET("Browser is set: %s"),

    // Element operations
    ERR_CLICK_FAILED("Click on element was failed: %s");

    private String messageText;

    MSG(String message) {
        this.messageText = message;
    }

    @Override
    public String toString() {
        return messageText;
    }
}
