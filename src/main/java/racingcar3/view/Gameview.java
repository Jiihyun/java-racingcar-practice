package racingcar3.view;


import racingcar3.model.Car;
import racingcar3.model.Cars;
import racingcar3.util.DashGenerator;
import racingcar3.util.RandomNumberGenerator;

import java.util.ArrayList;

public class Gameview {
    private final RandomNumberGenerator randomNumberGenerator;

    public Gameview(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void renderResult(int tryTimes, Cars cars) {
        for (int i = 0; i < tryTimes; i++) {
            cars.moveCars(randomNumberGenerator);
            ArrayList<Car> carList = cars.getCars();
            renderEachPersonResult(carList);
            System.out.println();
        }
    }

    public void renderEachPersonResult(ArrayList<Car> carList) {
        for (Car car : carList) {
            DashGenerator dashGenerator = new DashGenerator(car.getPosition()); //imp - 이것도 매번 생성되지 않게 생성자로 넣어주는 게 나은가?
            System.out.println(car.getName() + " : " + dashGenerator.positionToDash());
        }
    }

    public void renderWinner(Cars cars) {
        String nameList = String.join(",", cars.getWinnerList());
        System.out.println(nameList);
    }

}
