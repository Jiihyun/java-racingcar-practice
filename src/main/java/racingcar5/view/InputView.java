package racingcar5.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<String> inputName() {
        return Arrays.stream(Console.readLine()
                        .split(","))
                .collect(Collectors.toList());
    }
}
