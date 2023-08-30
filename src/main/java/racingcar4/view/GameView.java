package racingcar4.view;

import racingcar4.model.Car;
import racingcar4.model.Cars;
import racingcar4.utils.MessageConsts;
import racingcar4.utils.StringUtils;

import java.util.List;

public class GameView {
    public void renderAllResult(int tryTimes, Cars cars) {
        System.out.println(MessageConsts.GAME_RESULT_MSG);
        List<Car> carList = cars.getCarList();
        for (int i = 0; i < tryTimes; i++) {
            renderEachPersonResult(carList, i);
        }
        System.out.print(MessageConsts.WINNER_MSG);
        System.out.println(cars.getWinner());
    }

    public void renderEachPersonResult(List<Car> carList, int index) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + StringUtils.positionToDash(car.getPosition(index)));
        }
        System.out.println();
    }
}
