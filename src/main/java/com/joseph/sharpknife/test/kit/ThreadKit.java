package com.joseph.sharpknife.test.kit;

import java.util.Random;

/**
 * @author Joseph
 * @since 2022/3/8 10:13 PM
 */
public class ThreadKit {

    private static final Random r = new Random();

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int randomMillis() {
        return r.nextInt(1001);
    }

    public static int boundMillis(int bound) {
        return r.nextInt(bound + 1);
    }
}
