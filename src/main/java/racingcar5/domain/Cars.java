package racingcar5.domain;

import racingcar5.util.MovingPositionGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingcar5.util.MessaseConst.INPUT_NAME_LENGTH_EXCEPTION;
import static racingcar5.util.NumberConst.NAME_LENGTH_LIMIT;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            validateNameLength(name);
            cars.add(new Car(name));
        }
        this.carList = cars;
    }

    public static Cars from(List<String> names) {
        return new Cars(names);
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(INPUT_NAME_LENGTH_EXCEPTION);
        }
    }

    private static int getMaxPosition(int maxPosition, Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }

    public String getCarResult(int tryTimes, MovingPositionGenerator movingPositionGenerator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tryTimes; i++) {
            for (Car car : carList) {
                car.movePosition(movingPositionGenerator);
                sb.append(car.positionToDash());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getWinner() {
        Map<String, Integer> carMap = new HashMap<>();
        ArrayList<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : carList) {
            carMap.put(car.getName(), car.getPosition());
            maxPosition = getMaxPosition(maxPosition, car);
        }
        for (Map.Entry<String, Integer> car : carMap.entrySet()) {
            if (car.getValue() == maxPosition) {
                winners.add(car.getKey());
            }
        }
        return String.join(",", winners);
    }
}
