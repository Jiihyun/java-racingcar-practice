package racingcar3.controller;

import racingcar3.io.Printer;
import racingcar3.io.Reader;
import racingcar3.model.Cars;
import racingcar3.view.Gameview;

import java.util.List;

public class GameController { //요청, 요청 검증, 아래 계층에 처리 위임
    private final Reader reader;
    private final Printer printer;
    private final Gameview gameView;

    public GameController(Reader reader, Printer printer, Gameview gameView) {
        this.reader = reader;
        this.printer = printer;
        this.gameView = gameView;
    }

    public void start() {
        Cars cars = inputNames();
        int tryTimes = inputTryTimes();
        printer.printGameResultMsg();
        gameView.renderResult(tryTimes, cars);
        printer.printWinnerMsg();
        gameView.renderWinner(cars);
    }

    public Cars inputNames() {
        Cars cars = null;
        try {
            printer.printInputNamesMsg();
            List<String> carNames = reader.readNames();
            cars = new Cars(carNames);
        } catch (Exception e) {
            inputNames();
        }
        return cars;
    }

    public int inputTryTimes() {
        printer.printTryTimesMsg();
        //imp - try catch 예외 처리 해주기
        return reader.readTryTimes();
    }
}
