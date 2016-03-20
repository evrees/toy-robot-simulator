package com.evan.exercise.domain;

import com.evan.exercise.cardinaldirections.CardinalDirection;
import com.evan.exercise.commands.Reporter;
import com.evan.exercise.domain.enums.Facing;
import com.evan.exercise.domain.adapter.PositionUpdateAdapter;

public class Robot extends CanonicalObject implements MovableRobot {

    public final static int MOVE_UNIT = 1;
    private final PositionUpdateAdapter positionUpdateAdapter = new PositionUpdateAdapter(MOVE_UNIT);
    private final Reporter reporter = new Reporter();
    private Position currentPosition;
    private CardinalDirection currentCardinalDirection;

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Robot setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
        return this;
    }

    public CardinalDirection getCurrentCardinalDirection() {
        return currentCardinalDirection;
    }

    public Robot setCurrentCardinalDirection(CardinalDirection currentCardinalDirection) {
        this.currentCardinalDirection = currentCardinalDirection;
        return this;
    }

    public void move() {
        final Facing facing = currentCardinalDirection.getFacing();
        positionUpdateAdapter.moveInCurrentDirection(currentPosition, facing);
    }

    //TODO think about putting an index for left and right and cargo in the enum- then need a method to get
    public void rotateLeft() {
        currentCardinalDirection = currentCardinalDirection.rotateLeft();
    }

    public void rotateRight() {
        currentCardinalDirection = currentCardinalDirection.rotateRight();
    }

    public void report() {
        reporter.printLocation(currentPosition, currentCardinalDirection);
    }


}
