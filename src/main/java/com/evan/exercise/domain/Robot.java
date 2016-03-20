package com.evan.exercise.domain;

import com.evan.exercise.commands.Reporter;
import com.evan.exercise.domain.adapter.PositionUpdateAdapter;
import com.evan.exercise.domain.enums.CardinalDirection;

public class Robot extends CanonicalObject implements MovableRobot {

    public final static int MOVE_UNIT = 1;
    private final PositionUpdateAdapter positionUpdateAdapter = new PositionUpdateAdapter(MOVE_UNIT);
    private final Reporter reporter = new Reporter();
    private Position currentPosition;
    private CardinalDirection cardinalDirection;

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Robot setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
        return this;
    }

    public Robot setFacing(CardinalDirection cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
        return this;
    }

    @Override
    public Facing getFacing() {
        return cardinalDirection;
    }

    @Override
    public void rotateLeft() {
        cardinalDirection = cardinalDirection.getLeft();
    }

    @Override
    public void rotateRight() {
        cardinalDirection = cardinalDirection.getRight();
    }

    @Override
    public void report() {
        reporter.printLocation(currentPosition, cardinalDirection);
    }

    @Override
    public void move() {
        positionUpdateAdapter.moveInCurrentDirection(currentPosition, cardinalDirection);
    }
}
