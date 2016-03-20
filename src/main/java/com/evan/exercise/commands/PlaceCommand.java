package com.evan.exercise.commands;

import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.transformer.StringListToRobotTransformer;
import com.evan.exercise.validator.PlaceCommandValidator;

import java.util.Arrays;
import java.util.List;

public class PlaceCommand {

    private final StringListToRobotTransformer robotTransformer;
    private final PlaceCommandValidator placeCommandValidator;

    public PlaceCommand() {
        this(new StringListToRobotTransformer(), new PlaceCommandValidator());
    }

    public PlaceCommand(StringListToRobotTransformer robotTransformer, PlaceCommandValidator placeCommandValidator) {
        this.robotTransformer = robotTransformer;
        this.placeCommandValidator = placeCommandValidator;
    }

    public MovableRobot placeRobot(String command) {
        final List<String> placeCommandParts = Arrays.asList(command.split("\\,| "));
        placeCommandValidator.validate(placeCommandParts);
        return robotTransformer.createRobot(placeCommandParts);
    }


}
