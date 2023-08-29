package racingcar3.util;

public class StringUtils {
    public static String positionToDash(int position) {
        StringBuilder moving = new StringBuilder();
        for (int i = 0; i < position; i++) {
            moving.append("-");
        }
        return moving.toString();
    }
}
