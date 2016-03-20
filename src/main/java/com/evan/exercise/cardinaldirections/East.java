package com.evan.exercise.cardinaldirections;

import com.evan.exercise.domain.enums.Facing;

public class East implements CardinalDirection {
    private static North left = new North();
    private static South right = new South();

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
        return Facing.EAST;
    }
}
