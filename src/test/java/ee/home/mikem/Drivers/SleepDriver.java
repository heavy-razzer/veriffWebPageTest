package ee.home.mikem.Drivers;

import ee.home.mikem.Utils.Log;

import static ee.home.mikem.Objects.MSG.ERR_SLEEP_FAILED;

public class SleepDriver {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Log.errLog(ERR_SLEEP_FAILED);
        }
    }
}
