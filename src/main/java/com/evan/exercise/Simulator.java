package com.evan.exercise;

import com.evan.exercise.domain.adapter.CommandAdapter;

import java.util.List;

import static com.evan.exercise.domain.enums.AvailableCommand.PLACE;

public class Simulator {

    private final CommandAdapter commandAdapter = new CommandAdapter();

    public void process(List<String> commands) {
        commands.forEach(this::processCommand);
    }

    public void processCommand(String command) {
        if (command.startsWith(PLACE.name())) {
            commandAdapter.placeOnBoard(command);
        } else {
            attemptCommand(command);
        }
    }

    private void attemptCommand(String command) {
        if (commandAdapter.hasRobotBeenPlaced()) {
            commandAdapter.process(command);
        }
    }
}
