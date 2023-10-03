package racingcar5.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar5.util.NumberConst.*;

public class MovingPositionGenerator {
    public boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(START_INCULSIVE, END_INCULSIVE);
        return randomNumber >= MOVE_POSITION_STANDARD;
    }
}
