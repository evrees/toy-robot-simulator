package com.evan.exercise.transformer;

import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.Robot;
import com.evan.exercise.domain.enums.CardinalDirection;

import java.util.List;

public class StringListToRobotTransformer {

    private static final int FACING_ELEMENT = 3;

    private final StringListToPositionTransformer stringListToPositionTransformer;

    public StringListToRobotTransformer() {
        this(new StringListToPositionTransformer());
    }

    StringListToRobotTransformer(StringListToPositionTransformer stringListToPositionTransformer) {
        this.stringListToPositionTransformer = stringListToPositionTransformer;
    }

    public MovableRobot createRobot(List<String> placeCommandParts) {
        final Position position = stringListToPositionTransformer.process(placeCommandParts);
        final CardinalDirection facing = getFacing(placeCommandParts);
        return new Robot()
                .setCurrentPosition(position)
                .setFacing(facing);
    }

    private CardinalDirection getFacing(List<String> placeCommandParts) {
        String facing = placeCommandParts.get(FACING_ELEMENT);
        return CardinalDirection.valueOf(facing);
    }
}
