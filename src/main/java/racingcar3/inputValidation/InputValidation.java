package racingcar3.inputValidation;

import racingcar3.util.MessageConst;

import java.util.List;

public class InputValidation {

    public final void validateInputName(final List<String> carNameStringList) {
        validateCarNameDuplicated(carNameStringList);
    }

    private void validateCarNameDuplicated(final List<String> carNameStringList) {
        if (carNameStringList.stream().distinct().count() != carNameStringList.size()) {
            System.out.println(MessageConst.NAME_DUPLICATE_EXCEPTION_MSG);
            throw new IllegalArgumentException();
        }
    }


//    private final void validateNullName()
}
