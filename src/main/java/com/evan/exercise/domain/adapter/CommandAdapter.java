package com.evan.exercise.domain.adapter;

import com.evan.exercise.commands.RobotPlacer;
import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.enums.AvailableCommand;

import java.util.Optional;

public class CommandAdapter {

    private final RobotPlacer robotPlacer;
    private Optional<MovableRobot> robot = Optional.empty();

    public CommandAdapter() {
        robotPlacer = new RobotPlacer();
    }

    CommandAdapter(RobotPlacer robotPlacer) {
        this.robotPlacer = robotPlacer;
    }

    public void placeOnBoard(String placeCommand) {
        robot = Optional.of(robotPlacer.placeRobot(placeCommand));
    }

    public boolean hasRobotBeenPlaced() {
        return robot.isPresent();
    }

    public void process(String command) {
        if (hasRobotBeenPlaced()) {
            actionCommand(AvailableCommand.valueOf(command));
        }
    }

    private void actionCommand(AvailableCommand requestedCommand) {
        switch (requestedCommand) {
            case MOVE:
                robot.get().move();
                break;
            case LEFT:
                robot.get().rotateLeft();
                break;
            case RIGHT:
                robot.get().rotateRight();
                break;
            case REPORT:
                robot.get().report();
                break;
            default:
                throw new IllegalArgumentException(requestedCommand + " is not an available command");
        }
    }


}
