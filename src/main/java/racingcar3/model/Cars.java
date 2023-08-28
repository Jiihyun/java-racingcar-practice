package racingcar3.model;

import java.util.ArrayList;
import java.util.List;

public final class Cars {
    private final ArrayList<Car> cars;

    public Cars(List<String> carNameStringList) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String car : carNameStringList) {
            cars.add(new Car(car));
        }
        this.cars = cars;
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


}
