package com.evan.exercise.reader;

import com.evan.exercise.exception.RobotSimulatorException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.lines;

public class FileReader {

    public static final String FILE_CANT_BE_READ = " could not be read.";

    public static List<String> readCommandsFromFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            return lines(path).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RobotSimulatorException(e.getMessage() + FILE_CANT_BE_READ, e.getCause());
        }

    }

}
