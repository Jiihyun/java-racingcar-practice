package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum < 4) {
            System.out.println(name + " : " + moveResult());
            return;
        }
        position++;
        System.out.println(name + " : " + moveResult());
    }

    public String moveResult() { //stringBuilder == 동적배열 사용해보기
        String dash = "";
        for (int i = 0; i < position; i++) {
            dash += "-";
        }
        return dash;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
