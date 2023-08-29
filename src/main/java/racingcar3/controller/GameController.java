package racingcar3.controller;

import racingcar3.io.Printer;
import racingcar3.io.Reader;
import racingcar3.model.Cars;
import racingcar3.service.CarService;
import racingcar3.util.MessageConst;
import racingcar3.view.Gameview;

import java.util.List;

public class GameController { //요청, 요청 검증, 아래 계층에 처리 위임
    private final Reader reader;
    private final Printer printer;
    private final Gameview gameView;
    private final CarService carService;

    public GameController(Reader reader, Printer printer, Gameview gameView, CarService carService) {
        this.reader = reader;
        this.printer = printer;
        this.gameView = gameView;
        this.carService = carService;
    }

    public void start() {
        Cars cars = inputNames();
        int tryTimes = inputTryTimes();
        printer.printGameResultMsg();
        carService.execute(tryTimes, cars);
        gameView.renderResult(tryTimes, cars);
        printer.printWinnerMsg();
        gameView.renderWinner(cars);
    }

    public Cars inputNames() {
        try {
            printer.printInputNamesMsg();
            List<String> carNames = reader.readNames();
            return new Cars(carNames);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int inputTryTimes() {
        try {
            printer.printTryTimesMsg();
            return reader.readTryTimes();
        } catch (Exception e) {
            System.out.println(MessageConst.INPUT_TRYTIMES_EXCEPTION_MSG);
            throw new IllegalArgumentException();
        }

    }
}
