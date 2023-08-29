package racingcar3.model;

import racingcar3.util.MessageConst;
import racingcar3.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public final class Cars {
    private final ArrayList<Car> cars;

    public Cars(List<String> carNameStringList) {
        ArrayList<Car> cars = new ArrayList<>();
        validateCarNameDuplicated(carNameStringList);
        for (String car : carNameStringList) {
            cars.add(new Car(car));
        }
        this.cars = cars;
    }

    private static void validateCarNameDuplicated(List<String> carNameStringList) {
        if (carNameStringList.stream().distinct().count() != carNameStringList.size()) {
            throw new IllegalArgumentException(MessageConst.NAME_DUPLICATE_EXCEPTION_MSG);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        int maxLastPosition = 0;
        for (Car car : cars) {
            maxLastPosition = Math.max(car.getLastPosition(), maxLastPosition);
//            int position = car.getPosition();
//            if (position > maxPosition) {
//                maxPosition = position;
//            }
        }
        return maxLastPosition;
    }

    public ArrayList<String> getWinnerList() {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getLastPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public void moveCars(int tryTimes, RandomNumberGenerator randomNumberGenerator) {
        for (int i = 0; i < tryTimes; i++) {
            for (Car car : cars) {
                car.moveCar(randomNumberGenerator);
            }
        }
    }

}
