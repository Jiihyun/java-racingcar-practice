package racingcar4.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    public List<String> readNames() {
        return Arrays.stream(Console.readLine().split(",")).collect(Collectors.toList());
    }

    public int readTryTimes() {
        return Integer.parseInt(Console.readLine());
    }
}
