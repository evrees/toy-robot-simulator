package com.evan.exercise;

import com.evan.exercise.commands.PlaceCommand;
import com.evan.exercise.domain.MovableRobot;
import com.evan.exercise.domain.adapter.CommandAdapter;

import java.util.List;
import java.util.Optional;

import static com.evan.exercise.domain.enums.AvailableCommand.PLACE;

public class Simulator {

    private Optional<CommandAdapter> commandAdapter = Optional.empty();

    public void process(List<String> commands) {
        commands.forEach(this::processCommand);
    }

    public void processCommand(String command) {
        if (command.startsWith(PLACE.name())) {
            placeOnBoard(command);
        } else {
            attemptCommand(command);
        }
    }

    private void placeOnBoard(String placeCommand) {
        MovableRobot robot = new PlaceCommand().attemptRobotPlacement(placeCommand);
        commandAdapter = Optional.of(new CommandAdapter(robot));
    }

    private void attemptCommand(String command) {
        if (robotPlacedOnBoard()) {
            commandAdapter.get().process(command);
        }
    }

    private boolean robotPlacedOnBoard() {
        return commandAdapter.isPresent();
    }
}
