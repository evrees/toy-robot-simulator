package com.evan.exercise;

import com.evan.exercise.exception.RobotSimulatorException;

import java.util.List;

import static com.evan.exercise.reader.FileReader.readCommandsFromFile;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;

public class Application {

    protected static final String NO_FILE_PROVIDED = "No file location provided";

    public static void main(String[] args) {
        validateSystemInput(args);
        final String filePath = args[0];
        List<String> commands = readCommandsFromFile(filePath);
        run(commands);
    }

    private static void validateSystemInput(String[] args) {
        if (isEmpty(args)) {
            throw new RobotSimulatorException(NO_FILE_PROVIDED);
        }
    }

    private static void run(List<String> commands) {
        Simulator simulator = new Simulator();
        simulator.process(commands);
    }
}
