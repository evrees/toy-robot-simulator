package com.evan.exercise.commands;

import com.evan.exercise.domain.Facing;
import com.evan.exercise.domain.Position;

public class Reporter {

    public void printLocation(Position position, Facing facing) {
        System.out.format("Output: %s,%s,%s \n", position.getX(), position.getY(), facing);
    }
}
