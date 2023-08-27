package racingcar3.controller;

import racingcar3.io.Printer;
import racingcar3.io.Reader;
import racingcar3.service.CarService;
import racingcar3.view.Gameview;

public class GameController { //요청, 요청 검증, 아래 계층에 처리 위임
    private final Reader reader;
    private final Printer printer;
    private final Gameview gameView;
    private final CarService carService;


    public GameController(Reader reader, Printer printer, Gameview gameView ,CarService carService) {
        this.reader = reader;
        this.printer = printer;
        this.gameView = gameView;
        this.carService = carService;
    }

    public void start() {
        printer.printNames();
        reader.readNames();
        printer.printTryTimes();
        reader.readTryTimes();
//        gameview.결과들출력()
        printer.printWinner();
        //서비스 호출
//        carService.qmffgf()
    }
}
