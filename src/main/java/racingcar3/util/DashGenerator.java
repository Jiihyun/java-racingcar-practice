package racingcar3.util;

public class DashGenerator {
    private final int position;

    public DashGenerator(int position) {
        this.position = position;
    }

    public String positionToDash() {
        StringBuilder moving = new StringBuilder();
        for (int i = 0; i < position; i++) {
            moving.append("-");
        }
        return moving.toString();
    }
}
