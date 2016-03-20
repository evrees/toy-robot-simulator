package com.evan.exercise.test.util;

public class RandomUtil {

    public static Integer randomInt() {
        return randomInt(100);
    }

    public static Integer randomInt(int n) {
        return 1 + org.apache.commons.lang.math.RandomUtils.nextInt(n);
    }
}
