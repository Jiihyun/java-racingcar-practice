package racingcar2;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        Container container = new Container();

        GameController gameController = container.gameController();
        gameController.start();
        //controller에서 요청 처리
        // -> model 만들기
        // -> view 로 model 보내면서 렌더링 및 응답 위임
    }
}
