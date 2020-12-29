package me.intriguing.util.Util;

import java.util.Random;

public class NumUtil {

    public static boolean chance(double percentage) {
        Random r = new Random();
        return r.nextInt(100) + 1 <= percentage;
    }

}
