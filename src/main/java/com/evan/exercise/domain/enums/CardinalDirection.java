package com.evan.exercise.domain.enums;

import com.evan.exercise.domain.Facing;

public enum CardinalDirection implements Facing<CardinalDirection> {
    NORTH("WEST", "EAST"),
    SOUTH("EAST", "WEST"),
    EAST("NORTH", "SOUTH"),
    WEST("SOUTH", "NORTH");

    final String left;
    final String right;

    CardinalDirection(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public CardinalDirection getLeft() {
        return valueOf(left);
    }

    public CardinalDirection getRight() {
        return valueOf(right);
    }
}
