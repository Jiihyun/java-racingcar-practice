package racingcar3;

import racingcar3.controller.GameController;
import racingcar3.io.Printer;
import racingcar3.io.Reader;
import racingcar3.util.RandomNumberGenerator;
import racingcar3.view.Gameview;

public class Application {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Printer printer = new Printer();
        Gameview gameview = new Gameview(new RandomNumberGenerator());
        GameController gameController = new GameController(reader, printer, gameview);

        gameController.start();
    }
}
