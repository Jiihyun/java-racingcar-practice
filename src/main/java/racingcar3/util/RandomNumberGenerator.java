package racingcar3.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(NumberConst.START_INCLUSIVE, NumberConst.END_INCLUSIVE);
    }
}
