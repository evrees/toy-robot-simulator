package com.evan.exercise.commands;

import com.evan.exercise.cardinaldirections.CardinalDirection;
import com.evan.exercise.domain.Position;

public class Reporter {

    public void printLocation(Position position, CardinalDirection cardinalDirection) {
        System.out.format("Output: %s,%s,%s \n", position.getX(), position.getY(), cardinalDirection.getFacing());
    }
}
