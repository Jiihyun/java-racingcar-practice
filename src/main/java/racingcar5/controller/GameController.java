package racingcar5.controller;

import racingcar5.view.InputView;
import racingcar5.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<String> names = inputView.inputName();

    }
}
