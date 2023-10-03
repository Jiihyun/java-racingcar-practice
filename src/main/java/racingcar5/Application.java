package racingcar5;

import racingcar5.controller.GameController;
import racingcar5.util.MovingPositionGenerator;
import racingcar5.view.InputView;
import racingcar5.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        MovingPositionGenerator movingPositionGenerator = new MovingPositionGenerator();
        GameController gameController = new GameController(inputView, outputView, movingPositionGenerator);
        gameController.start();
    }
}
