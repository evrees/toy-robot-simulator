package com.evan.exercise.domain;

public interface MovableRobot {
    void move();
    void rotateLeft();
    void rotateRight();
    void report();

    UpdatablePosition getCurrentPosition();
    Facing getFacing();
}
