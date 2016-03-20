package com.evan.exercise.domain;

import com.evan.exercise.cardinaldirections.CardinalDirection;

public interface MovableRobot {
    void move();
    void rotateLeft();
    void rotateRight();
    void report();

    UpdatablePosition getCurrentPosition();
    CardinalDirection getCurrentCardinalDirection();
}
