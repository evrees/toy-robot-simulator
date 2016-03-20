package com.evan.exercise;

import java.util.List;

import static com.evan.exercise.exception.RobotSimulatorException.noInput;
import static com.evan.exercise.reader.FileReader.readCommandsFromFile;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;

public class Application {

    public static void main(String[] args) {
        validateSystemInput(args);
        final String filePath = args[0];
        List<String> commands = readCommandsFromFile(filePath);
        run(commands);
    }

    private static void validateSystemInput(String[] args) {
        if (isEmpty(args)) {
            throw noInput();
        }
    }

    private static void run(List<String> commands) {
        Simulator simulator = new Simulator();
        simulator.process(commands);
    }
}
