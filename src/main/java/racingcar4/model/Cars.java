package racingcar4.model;

import racingcar4.utils.MessageConsts;
import racingcar4.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> carList;

    public Cars(List<String> carListByString) {
        List<Car> carList = new ArrayList<>();
        validateCarsIfNameIsDupulicate(carListByString);
        for (String car : carListByString) {
            carList.add(new Car(car));
        }
        this.carList = carList;
    }

    public static void validateCarsIfNameIsDupulicate(List<String> carListByString) {
        if (carListByString.size() != carListByString.stream().distinct().count()) {
            throw new IllegalArgumentException(MessageConsts.NAME_DUPLICATE_EXCEPTION);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveCars(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : carList) {
            car.moveCar(randomNumberGenerator);
        }
        System.out.println();
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(car.getLastPosition(), maxPosition);
        }
        return maxPosition;
    }

    public String getWinner() {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : carList) {
            if (car.getLastPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return String.join(", ", winnerList);
    }
}
