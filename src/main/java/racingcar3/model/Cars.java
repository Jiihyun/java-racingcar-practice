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
            System.out.println(MessageConst.NAME_DUPLICATE_EXCEPTION_MSG);
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > maxPosition) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }

    public ArrayList<String> getWinnerList() {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public void moveCars(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.moveCar(randomNumberGenerator);
        }
    }

}
