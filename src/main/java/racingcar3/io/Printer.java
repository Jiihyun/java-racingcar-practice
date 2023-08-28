package racingcar3.io;

import racingcar3.util.MessageConst;

public class Printer {
    public void printInputNamesMsg() {
        System.out.println(MessageConst.INPUT_NAME_MSG);
    }

    public void printTryTimesMsg() {
        System.out.println(MessageConst.INPUT_TRYTIMES_MSG);
    }

    public void printGameResultMsg() {
        System.out.println();
        System.out.println(MessageConst.GAME_RESULT_MSG);
    }

    public void printWinnerMsg() {
        //최종 우승자 : 다음에 carname 들어와야 하므로 개행x
        System.out.print(MessageConst.WINNER_MSG);
    }
}
