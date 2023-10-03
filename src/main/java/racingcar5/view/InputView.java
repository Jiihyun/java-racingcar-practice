package racingcar5.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar5.util.MessaseConst.INPUT_TRY_TIMES_EXCEPTION;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<String> inputName() {
        outputView.inputNameMsg();
        return Arrays.stream(Console.readLine()
                        .split(","))
                .collect(Collectors.toList());
    }

    public int inputTryTimes() {
        try {
            outputView.inputTryTimesMsg();
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TRY_TIMES_EXCEPTION);
        }
    }
}
