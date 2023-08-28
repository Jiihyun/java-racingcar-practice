package racingcar3.model;

import racingcar3.util.MessageConst;
import racingcar3.util.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            System.out.println(MessageConst.NAME_LENGTH_EXCEPTION_MSG);
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int incrementPosition(RandomNumberGenerator randomNumberGenerator) {
        if (randomNumberGenerator.generate() >= 4) {
            position++;
        }
        return position;
    }

    public void moveCar() {
        incrementPosition(new RandomNumberGenerator());
    }
}
