package com.evan.exercise.transformer;

import com.evan.exercise.cardinaldirections.CardinalDirection;
import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.Position;
import com.evan.exercise.domain.Robot;
import com.evan.exercise.factory.CardinalDirectionFactory;

import java.util.List;

public class StringListToRobotTransformer {

    private static final int FACING_ELEMENT = 3;

    private final CardinalDirectionFactory cardinalDirectionFactory;
    private final StringListToPositionTransformer stringListToPositionTransformer;

    public StringListToRobotTransformer() {
        this(new CardinalDirectionFactory(), new StringListToPositionTransformer());
    }

    public StringListToRobotTransformer(CardinalDirectionFactory cardinalDirectionFactory, StringListToPositionTransformer stringListToPositionTransformer) {
        this.cardinalDirectionFactory = cardinalDirectionFactory;
        this.stringListToPositionTransformer = stringListToPositionTransformer;
    }

    public MovableRobot createRobot(List<String> placeCommandParts) {
        final Position position = stringListToPositionTransformer.process(placeCommandParts);
        final CardinalDirection cardinalDirection = createDirection(placeCommandParts);
        return new Robot()
                .setCurrentPosition(position)
                .setCurrentCardinalDirection(cardinalDirection);
    }

    private CardinalDirection createDirection(List<String> placeCommandParts) {
        String facing = placeCommandParts.get(FACING_ELEMENT);
        return cardinalDirectionFactory.get(facing);
    }
}
