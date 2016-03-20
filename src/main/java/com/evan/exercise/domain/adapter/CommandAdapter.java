package com.evan.exercise.domain.adapter;

import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.enums.AvailableCommand;

public class CommandAdapter {

    private final MovableRobot robot;

    public CommandAdapter(MovableRobot robot) {
        this.robot = robot;
    }

    public void process(String command) {
        final AvailableCommand requestedCommand = AvailableCommand.valueOf(command);
        switch (requestedCommand) {
            case MOVE:
                robot.move();
                break;
            case LEFT:
                robot.rotateLeft();
                break;
            case RIGHT:
                robot.rotateRight();
                break;
            case REPORT:
                robot.report();
                break;
            default:
                throw new IllegalArgumentException(command + " is not an available command");
        }
    }


}
