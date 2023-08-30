package racingcar4;

import racingcar4.controller.GameController;
import racingcar4.io.Printer;
import racingcar4.io.Reader;
import racingcar4.service.CarService;
import racingcar4.utils.RandomNumberGenerator;
import racingcar4.view.GameView;

public class Application {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Reader reader = new Reader();
        CarService carService = new CarService(new RandomNumberGenerator());
        GameView gameView = new GameView();
        GameController gameController = new GameController(printer, reader, carService, gameView);
        gameController.start();
    }
}
