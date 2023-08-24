package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)\n");
        String name = Console.readLine();
        String[] nameArr = name.split(",");
        Car[] cars = new Car[nameArr.length];
        Result result = new Result(nameArr, cars);
        for (int i = 0; i < result.nameArr.length; i++) {
            try {
                if (result.nameArr[i].length() > 5) {
                    throw new IllegalArgumentException();
                }
                result.cars[i] = new Car(result.nameArr[i]);
            } catch (Exception e) {
                System.out.println("[ERROR]: 이름은 5자 이하만 가능합니다.");
            }
        }

        System.out.println("시도할 회수는 몇회인가요?\n");
        String tryTimes = Console.readLine();

        int tryTime = Integer.parseInt(tryTimes);
        System.out.println("실행 결과\n");
        while (tryTime > 0) {
            for (Car car : result.cars) {
                car.move();
            }
            System.out.println();
            tryTime--;
        }

        List<Car> winnerList = Arrays.stream(result.cars)
                .sorted(Comparator.comparingInt(Car::getPosition).reversed())
                .collect(Collectors.toList());

        List<Car> winner = new ArrayList<>();
        for (
                int i = 0; i < winnerList.size(); i++) {
            int winnerPosition = winnerList.get(0).getPosition();
            if (winnerList.get(i).getPosition() == winnerPosition) {
                winner.add(winnerList.get(i));
            }
        }
        System.out.print("최종 우승자 : ");
        for (
                int i = 0; i < winner.size(); i++) {
            Car car = winner.get(i);
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(car.getName());
        }
        System.out.println();

    }

    private static class Result {
        public final String[] nameArr;
        public final Car[] cars;

        public Result(String[] nameArr, Car[] cars) {
            this.nameArr = nameArr;
            this.cars = cars;
        }
    }

}
