package racingcar2;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    // 추가 기능 구현
    public void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void moveChance() {
        if (Randoms.pickNumberInRange(1, 9) >= 4) {
            position++;
        }
    }

    public String carMove() {
        StringBuilder moving = new StringBuilder();
        for (int i = 0; i < position; i++) {
            moving.append("-");
        }
        return moving.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
