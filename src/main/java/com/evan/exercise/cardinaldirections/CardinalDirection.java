package com.evan.exercise.cardinaldirections;

import com.evan.exercise.domain.enums.Facing;

public interface CardinalDirection {
    public CardinalDirection rotateLeft();
    public CardinalDirection rotateRight();
    public Facing getFacing();
}
