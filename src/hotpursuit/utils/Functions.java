package hotpursuit.utils;

import java.util.Random;

public class Functions {
    private static final Random random = new Random();

    public static int getRandomInt(int maxVal){
        return random.nextInt(maxVal);
    }
}
