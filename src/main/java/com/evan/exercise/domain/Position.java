package com.evan.exercise.domain;

import com.evan.exercise.validator.PointValidator;

import java.util.function.Consumer;

public class Position extends CanonicalObject implements UpdatablePosition {

    private PointValidator pointValidator;
    private int x;
    private int y;

    public Position() {
        pointValidator = new PointValidator();
    }

    public Position(PointValidator pointValidator) {
        this.pointValidator = pointValidator;
    }

    public Position setX(int x) {
        this.x = x;
        return this;
    }

    public Position setY(int y) {
        this.y = y;
        return this;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void incrementY(int moveUnit) {
        updatePoint(this::setY, y + moveUnit);
    }

    @Override
    public void decrementY(int moveUnit) {
        updatePoint(this::setY, y - moveUnit);
    }

    @Override
    public void incrementX(int moveUnit) {
        updatePoint(this::setX, x + moveUnit);
    }

    @Override
    public void decrementX(int moveUnit) {
        updatePoint(this::setX, x - moveUnit);
    }

    private void updatePoint(Consumer<Integer> nextPointConsumer, int nextPoint) {
        if (pointValidator.isPointWithinTableBounds(nextPoint)) {
            nextPointConsumer.accept(nextPoint);
        }
    }
}
