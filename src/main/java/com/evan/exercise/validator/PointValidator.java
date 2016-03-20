package com.evan.exercise.validator;

public class PointValidator {

    public static final int MAX_POSITION = 4;
    public static final int MIN_POSITION = 0;

    public boolean isPointWithinTableBounds(int point) {
        return point <= MAX_POSITION && point >= MIN_POSITION;
    }
}
