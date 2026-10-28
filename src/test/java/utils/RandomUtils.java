package utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static <T> T getRandomItemFromList(List<T> items) {
        return items.get(getRandomInt(0, items.size() - 1));
    }
}
