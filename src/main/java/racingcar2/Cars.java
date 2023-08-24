package racingcar2;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public final class Cars { //일급 컬렉션 / 캡슐화 / adt(추상데이터타입)
    // String list는 스트링밖에 없으므로 Cars 리스트를 만들어줘서 name이랑 position가져올 수 있게함
    // 이 때 cars를 map으로 만들면 자동완성x & 그로인한 오타 안 잡아주므로 비추
    private final List<racingcar.Car> cars;

    public Cars(List<String> carNames) {
        List<racingcar.Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new racingcar.Car(carNames.get(i)));

        }
        this.cars = cars;
    }

    public List<racingcar.Car> getCarList() {
        return cars;
    }

    public int getHighestPosition() {
        int hightestNum = 0;
        for (racingcar.Car car : cars) {
            int presentNum = car.getPosition();
            if (presentNum > hightestNum) {
                hightestNum = presentNum;
            }
        }
        return hightestNum;
    }

    public String getWinner() {  //List<Car> getMaxPositionCars()
        ArrayList<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == getHighestPosition()) {
                winnerList.add(car.getName());
            }
        }
        String winner = String.join(", ", winnerList);
        return winner;
    }
}
