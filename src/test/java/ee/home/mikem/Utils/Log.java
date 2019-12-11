package ee.home.mikem.Utils;

import ee.home.mikem.Objects.Colours;
import org.junit.Assert;

import static ee.home.mikem.Objects.DateFormats.SHORT_TIME;
import static ee.home.mikem.Utils.OsUtils.timeStamp;

/*
Functions to print different information in log
 */
public class Log {

    public static void log(Object text, Object... args) {
        System.out.println(Colours.GREEN.getColour() + "[TEST]:  " + Colours.DEFAULT.getColour()
                + String.format(text.toString(), args));
    }

    public static void errLog(Object text, Object... args) {
        String msg = String.format(text.toString(), args);
        System.out.println(Colours.RED.getColour() + "[ERROR]:  " + Colours.DEFAULT.getColour()
                + timeStamp(SHORT_TIME) + "  "
                + msg);
        Assert.fail(msg);
    }

    public static void sysLog(Object text, Object... args) {
        System.out.println(Colours.BLUE.getColour() + "[SYSTEM]:  " + Colours.DEFAULT.getColour()
                + timeStamp(SHORT_TIME) + "  "
                + String.format(text.toString(), args));
    }

    public static void print(Object text, Colours colour) {
        System.out.println(colour.getColour() + text.toString() + Colours.DEFAULT.getColour());
    }
}