package com.evan.exercise.factory;

import com.evan.exercise.cardinaldirections.*;
import com.evan.exercise.domain.enums.Facing;

import static com.evan.exercise.exception.RobotSimulatorException.invalidFacing;
import static org.apache.commons.lang3.StringUtils.upperCase;

public class CardinalDirectionFactory {

    public static final North north = new North();
    public static final South south = new South();
    public static final East east = new East();
    public static final West west = new West();

    public CardinalDirection get(String facing) {
        final Facing cardinalDirectionFacing = Facing.valueOf(upperCase(facing));

        switch (cardinalDirectionFacing) {
            case NORTH:
                return north;
            case SOUTH:
                return south;
            case EAST:
                return east;
            case WEST:
                return west;
            default:
                throw invalidFacing();
        }
    }


}
