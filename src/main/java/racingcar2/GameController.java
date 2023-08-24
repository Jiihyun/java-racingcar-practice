package racingcar2;

import java.util.List;

public class GameController {
    private final Reader reader;
    private final Printer printer;
    private final GameView gameView;

    public GameController(
            final Reader reader,
            final Printer printer,
            final GameView gameView
    ) {
        this.reader = reader;
        this.printer = printer;
        this.gameView = gameView;
    }

    public void start() {
        // 입력 받기
        printer.printReadCarNamesmessage();
        Cars cars = tryReadCars();

        printer.printReadTryTimes();
        int tryTimes = reader.readTryTimes();

        gameView.render(cars, tryTimes);
    }

    private Cars tryReadCars() {
        List<String> carNames = reader.readCarNames();
        try {
            return new Cars(carNames);
        } catch (Exception e) {
            System.out.println("[ERROR] - 이름은 5자 이하만 가능합니다. 다시 입력해주세요.");
            return tryReadCars();
        }
    }
}
