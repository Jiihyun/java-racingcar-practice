package racingcar2;

public class GameView {
    //view에서는 데이터 가공을 하지 않음(렌더링 및 응답만) -> 데이터 변경 및 처리해주는 service계층 만들기
    //데이터 다 섞여있으므로 -> 계층을 나눌 것
    public void render(final Cars cars, final int tryTimes) {
        for (int trial = 0; trial < tryTimes; trial++) {
            for (int i = 0; i < cars.getCarList().size(); i++) {
                Car car = cars.getCarList().get(i);
                car.moveChance(); //이 부분이 데이터 처리해주는 거라 잘못됨
                String move = car.carMove();
                System.out.println(car.getName() + " : " + move);
            }
            System.out.println();
        }
        System.out.println("최종 우승자 : " + cars.getWinner());
    }
}
