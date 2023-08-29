package racingcar3.service;

import racingcar3.model.Cars;
import racingcar3.util.RandomNumberGenerator;

public class CarService {

    private final RandomNumberGenerator randomNumberGenerator;

    public CarService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void execute(int tryTimes, Cars cars) {
        cars.moveCars(tryTimes, randomNumberGenerator);
    }
}
