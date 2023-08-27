package racingcar3.controller;

import racingcar3.inputValidation.InputValidation;
import racingcar3.io.Printer;
import racingcar3.io.Reader;
import racingcar3.service.CarService;
import racingcar3.util.MessageConst;
import racingcar3.view.Gameview;

import java.util.List;

public class GameController { //요청, 요청 검증, 아래 계층에 처리 위임
    private final Reader reader;
    private final Printer printer;
    private final Gameview gameView;
    private final CarService carService;
    private final InputValidation inputValidation;

    public GameController(Reader reader, Printer printer, Gameview gameView, CarService carService, InputValidation inputValidation) {
        this.reader = reader;
        this.printer = printer;
        this.gameView = gameView;
        this.carService = carService;
        this.inputValidation = inputValidation;
    }

    public void start() {

        try {
            printer.printInputNamesMsg();
            List<String> carNames = reader.readNames();
            inputValidation.validateCarNameDuplicated(carNames);
        } catch (Exception e) {
            System.out.println(MessageConst.NAME_DUPLICATE_EXCEPTION_MSG);
            start();
        }

    }

    public void start2() {
        printer.printTryTimesMsg();
        reader.readTryTimes();
//        gameview.결과들출력()
        printer.printGameResultMsg();
        //서비스 호출
        printer.printWinnerMsg();

    }
}
