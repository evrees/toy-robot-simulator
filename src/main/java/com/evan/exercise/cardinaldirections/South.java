package com.evan.exercise.cardinaldirections;

import com.evan.exercise.domain.enums.Facing;

public class South implements CardinalDirection {
    private static East left = new East();
    private static West right = new West();

    @Override
    public CardinalDirection rotateLeft() {
        return left;
    }

    @Override
    public CardinalDirection rotateRight() {
        return right;
    }

    @Override
    public Facing getFacing() {
        return Facing.SOUTH;
    }
}
