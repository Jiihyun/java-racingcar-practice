package racingcar4.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(NumberConsts.START_INCLUSIVE, NumberConsts.END_INCLUSIVE);
    }
}
