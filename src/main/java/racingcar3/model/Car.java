package racingcar3.model;

import racingcar3.util.MessageConst;
import racingcar3.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private final List<Integer> positionHistory = new ArrayList<>();

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    //imp - 객체 생성 전에 메소드를 사용 해야 하므로 static으로 선언
    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            System.out.println(MessageConst.NAME_LENGTH_EXCEPTION_MSG);
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        if (positionHistory.isEmpty()) {
            return 0;
        }
        return positionHistory.get(getLastIndex());
    }

    private int getLastIndex() {
        return positionHistory.size() - 1;
    }


    public void moveCar(RandomNumberGenerator randomNumberGenerator) {
        int increasePosition = getPosition();
        if (canMove(randomNumberGenerator)) {
            positionHistory.add(++increasePosition);
            return;
        }
        positionHistory.add(getPosition());
    }

    public boolean canMove(RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.generate() >= 4;
    }
}
