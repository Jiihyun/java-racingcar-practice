package racingcar3.inputValidation;

import racingcar3.model.Car;
import racingcar3.model.Cars;
import racingcar3.util.MessageConst;

import java.util.ArrayList;
import java.util.List;

public class InputValidation {

    public final Cars validateInputName(final List<String> carNameStringList) {
        validateCarNameDuplicated(carNameStringList);
        return validateCarNameLength(new Cars(carNameStringList));
    }

    private void validateCarNameDuplicated(final List<String> carNameStringList) {
        if (carNameStringList.stream().distinct().count() != carNameStringList.size()) {
            System.out.println(MessageConst.NAME_DUPLICATE_EXCEPTION_MSG);
            throw new IllegalArgumentException();
        }
    }

    private Cars validateCarNameLength(final Cars cars) {
        ArrayList<Car> carList = cars.getCars();
        for (Car car : carList) {
            if (car.getName().length() > 5) {
                System.out.println(MessageConst.NAME_LENGTH_EXCEPTION_MSG);
                throw new IllegalArgumentException();
            }
        }
        return cars;
    }

//    private final void validateNullName()
}
