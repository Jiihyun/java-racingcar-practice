package racingcar3.view;


import racingcar3.io.Printer;
import racingcar3.model.Car;
import racingcar3.model.Cars;
import racingcar3.util.DashGenerator;

import java.util.ArrayList;

public class Gameview {
    public void render(Cars cars) {
        ArrayList<Car> carsList = cars.getCars();
        for (Car car : carsList) {
            System.out.println(car.getName() + " : " + new DashGenerator(car.getPosition()));
        }
    }

}
