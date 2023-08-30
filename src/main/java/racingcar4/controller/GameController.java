package racingcar4.controller;

import racingcar4.io.Printer;
import racingcar4.io.Reader;
import racingcar4.model.Cars;
import racingcar4.service.CarService;
import racingcar4.utils.MessageConsts;
import racingcar4.view.GameView;

import java.util.List;

public class GameController {
    Printer printer;
    Reader reader;
    CarService carService;
    GameView gameView;

    public GameController(Printer printer, Reader reader, CarService carService, GameView gameView) {
        this.printer = printer;
        this.reader = reader;
        this.carService = carService;
        this.gameView = gameView;
    }

    public void start() {
        Cars cars = inputNames();
        int tryTimes = inputTryTimes();
        carService.execute(cars, tryTimes);
        gameView.renderAllResult(tryTimes, cars);
    }

    public Cars inputNames() {
        try {
            printer.printNameMsg();
            List<String> carList = reader.readNames();
            return new Cars(carList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    public int inputTryTimes() {
        try {
            printer.printTryTimesMsg();
            return reader.readTryTimes();
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConsts.TRY_TIMES_TYPE_EXCEPTION);
            return inputTryTimes();
        }
    }
}
