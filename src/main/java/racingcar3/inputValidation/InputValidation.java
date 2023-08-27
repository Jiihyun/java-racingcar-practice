package racingcar3.inputValidation;

import racingcar3.model.Car;
import racingcar3.util.MessageConst;

import java.util.List;

public class InputValidation {

    public final void validateCarNameDuplicated(final List<String> carNameStringList) {
        if (carNameStringList.stream().distinct().count() != carNameStringList.size()) {
            throw new IllegalArgumentException();
        }
    }

    public final void validateCarNameLength(final Car car) {
        if (car.getName().length() > 5) {
            System.out.println(MessageConst.NAME_LENGTH_EXCEPTION_MSG);
            throw new IllegalArgumentException();
        }
    }

//    private final void validateNullName()
}
