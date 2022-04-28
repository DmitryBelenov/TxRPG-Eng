package utils;

public class GameUtils {
    public static synchronized void waitFor(long millis) {
        long to = System.currentTimeMillis() + millis;
        boolean wait;
        do {
            wait = to > System.currentTimeMillis();
        } while (wait);
    }
}
