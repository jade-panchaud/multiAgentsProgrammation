package tools;

import java.util.Random;

public class Util {
    private static final Random random = new Random();

    public static int randomInt(int min, int max) {
        return random.nextInt(max + min) - min;
    }

    public static int randomInt(int max) {
        return random.nextInt(max);
    }
}
