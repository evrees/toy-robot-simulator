package com.evan.exercise.domain.adapter;

import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.enums.Facing;

import static com.evan.exercise.exception.RobotSimulatorException.invalidFacing;

public class PositionUpdateAdapter {

    private final int moveUnit;

    public PositionUpdateAdapter(int moveUnit) {
        this.moveUnit = moveUnit;
    }

    public void moveInCurrentDirection(Position currentPosition, Facing facing) {
        switch (facing) {
            case NORTH:
                currentPosition.incrementY(moveUnit);
                break;
            case SOUTH:
                currentPosition.decrementY(moveUnit);
                break;
            case EAST:
                currentPosition.incrementX(moveUnit);
                break;
            case WEST:
                currentPosition.decrementX(moveUnit);
                break;
            default:
                throw invalidFacing();
        }
    }
}
