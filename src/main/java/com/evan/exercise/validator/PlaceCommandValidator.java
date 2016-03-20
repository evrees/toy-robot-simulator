package com.evan.exercise.validator;


import com.evan.exercise.domain.enums.Facing;

import java.util.List;

import static com.evan.exercise.exception.RobotSimulatorException.*;
import static org.apache.commons.lang3.EnumUtils.isValidEnum;
import static org.apache.commons.lang3.StringUtils.isNumericSpace;

public class PlaceCommandValidator  {

    private final PointValidator pointValidator = new PointValidator();

    public void validate(List<String> placeCommandParts) {
        if (placeCommandParts.size() != 4) {
            throw invalidPlaceCommand();
        }

        if (!isNumericSpace(placeCommandParts.get(1))) {
            throw invalidX();
        }
        if (!isNumericSpace(placeCommandParts.get(2))) {
            throw invalidY();
        }

        final int x = Integer.parseInt(placeCommandParts.get(1));
        final int y = Integer.parseInt(placeCommandParts.get(2));
        validatePointsWithinBounds(x, y);

        validateDirection(placeCommandParts.get(3));
    }

    private void validatePointsWithinBounds(int x, int y) {
        if (!pointValidator.isPointWithinTableBounds(x)) {
            throw invalidX();
        }
        if (!pointValidator.isPointWithinTableBounds(y)) {
            throw invalidY();
        }
    }

    private void validateDirection(String facing)  {
        if (!isValidEnum(Facing.class, facing)) {
            throw invalidFacing();
        }
    }

}
