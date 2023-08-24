package racingcar2;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
wrapper(=adapter)
'클래스'로 3-party 라이브러리 사용하는 코드를 랩핑할 때
-> 3-party 라이브러리 교체 가능성이 있는 경우 (ex : mongoose ->prisma)
   교체할 때 변경 포인트가 N -> 1로 줄어듦 (ex: scanner -> console)

   Reader는  Console에 의존함
   Console이 변경가능성이 존재하므로 Reader라는 클래스로 덮어서 변경 포인트를 한 번으로 줄여줌
 */

public class Reader {

    public List<String> readCarNames() {
        String carNames = Console.readLine();
        List<String> carNamesList = Arrays.stream(carNames.split(",")) // "a,b,c"
                .collect(Collectors.toList()); // ["a","b","c"]
        return carNamesList;
    }

    public int readTryTimes() {
        String tryTimes = Console.readLine();
        return Integer.parseInt(tryTimes);
    }

}
