package ee.home.mikem.Objects;

/*
List of supported browsers
 */
public class Browsers {

    public static String CHROME = "Chrome";
    public static String EDGE = "Edge";
    public static String IEXPLORER = "IE";
    public static String SAFARI = "Safari";

    public static boolean checkIfStringIsBrowser(String value) {
        value = value.toLowerCase();
        return value.equals(CHROME.toLowerCase()) ||
                value.equals(EDGE.toLowerCase()) ||
                value.equals(IEXPLORER.toLowerCase()) ||
                value.equals(SAFARI.toLowerCase());
    }
}
