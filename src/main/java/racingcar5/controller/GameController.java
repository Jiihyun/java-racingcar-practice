package racingcar5.controller;

import racingcar5.domain.Cars;
import racingcar5.util.MovingPositionGenerator;
import racingcar5.view.InputView;
import racingcar5.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovingPositionGenerator movingPositionGenerator;

    public GameController(InputView inputView, OutputView outputView, MovingPositionGenerator movingPositionGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingPositionGenerator = movingPositionGenerator;
    }

    private static Cars getCars(List<String> names) {
        try {
            return Cars.from(names);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void start() {
        try {
            List<String> names = inputView.inputName();
            int tryTimes = getTryTimes();
            Cars cars = getCars(names);
            String carResult = cars.getCarResult(tryTimes, movingPositionGenerator);
            outputView.printResult(carResult);
            String winners = cars.getWinner();
            outputView.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }

    private int getTryTimes() {
        try {
            return inputView.inputTryTimes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
