package racingcar2;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        Container container = new Container();
        GameController gameController = container.gameController();
        gameController.start();
    }
}
