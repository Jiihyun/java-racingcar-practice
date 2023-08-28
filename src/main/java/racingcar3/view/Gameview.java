package racingcar3.view;


import racingcar3.model.Car;
import racingcar3.model.Cars;
import racingcar3.util.DashGenerator;

import java.util.ArrayList;

public class Gameview {
    public void render(int tryTimes, Cars cars) {
        ArrayList<Car> carsList = cars.getCars();
        for (int i = 0; i < tryTimes; i++) {
            for (Car car : carsList) {
                car.moveCar();
                DashGenerator dashGenerator = new DashGenerator(car.getPosition());
                System.out.println(car.getName() + " : " + dashGenerator.positionToDash());
            }
            System.out.println();
        }
    }

}
