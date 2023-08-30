package racingcar4.model;

import racingcar4.utils.MessageConsts;
import racingcar4.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private final List<Integer> positionHistory = new ArrayList<>();

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(MessageConsts.NAME_LENGTH_EXCEPTION);
        }
    }

    public boolean canMove(RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.createRandomNumber() >= 4;
    }

    public void moveCar(RandomNumberGenerator randomNumberGenerator) {
        int position = getLastPosition();
        if (canMove(randomNumberGenerator)) {
            position++;
        }
        positionHistory.add(position);
    }

    public String getName() {
        return name;
    }

    public int getLastPosition() {
        if (positionHistory.isEmpty()) {
            return 0;
        }
        return positionHistory.get(getLastIndex());
    }

    private int getLastIndex() {
        return positionHistory.size() - 1;
    }

    public int getPosition(int index) {
        return positionHistory.get(index);
    }

}
