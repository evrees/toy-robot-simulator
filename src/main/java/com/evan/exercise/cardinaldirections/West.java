package com.evan.exercise.cardinaldirections;

import com.evan.exercise.domain.enums.Facing;

public class West implements CardinalDirection {
    private static South left = new South();
    private static North right = new North();

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
        return Facing.WEST;
    }
}
