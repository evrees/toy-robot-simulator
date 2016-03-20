package com.evan.exercise.transformer;

import com.evan.exercise.domain.Position;

import java.util.List;

public class StringListToPositionTransformer {

    private static final int X_ELEMENT = 1;
    private static final int Y_ELEMENT = 2;

    public Position process(List<String> instructions) {
        final int x = Integer.parseInt(instructions.get(X_ELEMENT));
        final int y = Integer.parseInt(instructions.get(Y_ELEMENT));
        return new Position()
                .setX(x)
                .setY(y);
    }
}
