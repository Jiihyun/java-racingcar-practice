package racingcar3.view;


import racingcar3.model.Car;
import racingcar3.model.Cars;
import racingcar3.util.StringUtils;

import java.util.ArrayList;

public class Gameview {


    public void renderResult(int tryTimes, Cars cars) {
        ArrayList<Car> carList = cars.getCars();
        for (int i = 0; i < tryTimes; i++) {
            renderEachPersonResult(carList, i);
            System.out.println();
        }
    }

    public void renderEachPersonResult(ArrayList<Car> carList, int index) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + StringUtils.positionToDash(car.getPosition(index))); //imp - 이것도 매번 생성되지 않게 생성자로 넣어주는 게 나은가? x static활용
        }
    }

    public void renderWinner(Cars cars) {
        String nameList = String.join(",", cars.getWinnerList());
        System.out.println(nameList);
    }

}

/* imp
선언 뿐만 아니라 미리 초기화까지 해주는 List
List.of(1,2,3) - java9 부터
Arrays.asList(1,2,3) - java 1.8에서는 List.of 대신 이거로
 */