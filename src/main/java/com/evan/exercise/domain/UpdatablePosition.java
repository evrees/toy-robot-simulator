package com.evan.exercise.domain;

public interface UpdatablePosition {
    void incrementY(int moveUnit);
    void decrementY(int moveUnit);
    void incrementX(int moveUnit);
    void decrementX(int moveUnit);

    int getX();
    int getY();
}
