package racingcar3;

import racingcar3.controller.GameController;
import racingcar3.inputValidation.InputValidation;
import racingcar3.io.Printer;
import racingcar3.io.Reader;
import racingcar3.view.Gameview;

public class Application {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Printer printer = new Printer();
        Gameview gameview = new Gameview();
        InputValidation inputValidation = new InputValidation();
        GameController gameController = new GameController(reader,printer,gameview,inputValidation);

        gameController.start();
    }
}
