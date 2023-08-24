package racingcar2;

public class Container {
    private Reader reader;
    private Printer printer;
    private GameController gameController;
    private GameView gameView;

    public Reader reader() {
        if (reader == null) {
            reader = new Reader();
        }
        return reader;
    }

    public Printer printer() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public GameView gameView() {
        if (gameView == null) {
            gameView = new GameView();
        }
        return gameView;
    }

    public GameController gameController() {
        if (gameController == null) {
            gameController = new GameController(
                    reader(),
                    printer(),
                    gameView()
            );
        }
        return gameController;
    }
}
