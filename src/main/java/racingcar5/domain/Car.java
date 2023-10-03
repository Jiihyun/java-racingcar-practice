package racingcar5.domain;

import racingcar5.util.MovingPositionGenerator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void movePosition(MovingPositionGenerator movingPositionGenerator) {
        if (movingPositionGenerator.canMove()) {
            position++;
        }
    }

    public String positionToDash() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
