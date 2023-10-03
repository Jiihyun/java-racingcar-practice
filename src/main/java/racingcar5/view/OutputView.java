package racingcar5.view;

import static racingcar5.util.MessaseConst.*;

public class OutputView {

    public void inputNameMsg() {
        System.out.println(INPUT_NAME_MSG);
    }

    public void inputTryTimesMsg() {
        System.out.println(INPUT_TRY_TIMES_MSG);
    }

    public void printResult(String result) {
        System.out.println(GAME_RESULT_MSG);
        System.out.println(result);
    }

    public void printWinners(String winners) {
        System.out.print(GAME_WINNER_MSG);
        System.out.println(winners);
    }

}
