package racingcar3.util;

public class DashGenerator {
    private final int position;

    public DashGenerator(int position) {
        this.position = position;
    }

    public String positionToDash() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(position).toString();
    }
}
