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

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(INPUT_NAME_LENGTH_EXCEPTION);
        }
    }

    private void addWinnerIfMaxPosition(ArrayList<String> winners, int maxPosition, Map.Entry<String, Integer> car) {
        if (car.getValue() == maxPosition) {
            winners.add(car.getKey());
        }
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
        ArrayList<String> winners = new ArrayList<>();
        Map<String, Integer> carMap = updateCarMap();
        int maxPosition = getMaxPosition(carMap);
        for (Map.Entry<String, Integer> car : carMap.entrySet()) {
            addWinnerIfMaxPosition(winners, maxPosition, car);
        }
        return String.join(",", winners);
    }

    private Map<String, Integer> updateCarMap() {
        Map<String, Integer> carMap = new HashMap<>();
        for (Car car : carList) {
            carMap.put(car.getName(), car.getPosition());
        }
        return carMap;
    }

    private int getMaxPosition(Map<String, Integer> carMap) {
        int maxPosition = 0;
        for (Integer position : carMap.values()) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }
}
