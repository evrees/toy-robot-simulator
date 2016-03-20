package com.evan.exercise.cardinaldirections;

import com.evan.exercise.domain.enums.Facing;

public class North implements CardinalDirection {
    private static West left = new West();
    private static East right = new East();

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
        return Facing.NORTH;
    }
}
