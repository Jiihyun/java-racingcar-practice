package racingcar4.service;

import racingcar4.model.Cars;
import racingcar4.utils.RandomNumberGenerator;

public class CarService {
    private final RandomNumberGenerator randomNumberGenerator;

    public CarService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void execute(Cars cars, int tryTimes) {
        for (int i = 0; i < tryTimes; i++) {
            cars.moveCars(randomNumberGenerator);
        }
    }
}
