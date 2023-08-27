package racingcar3.model;

import racingcar3.util.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int addPosition(RandomNumberGenerator randomNumberGenerator) {
        if (randomNumberGenerator.generate() >= 4) {
            position++;
        }
        return position;
    }
}
