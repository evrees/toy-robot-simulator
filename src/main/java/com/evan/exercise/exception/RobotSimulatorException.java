package com.evan.exercise.exception;


public class RobotSimulatorException extends RuntimeException {

    public static final String NO_FILE_PROVIDED = "No file location provided";
    public static final String INVALID_PLACE_COMMAND = "Invalid Place command line. please use format of PLACE X,Y,FACING";
    public static final String INVALID_FACING = "Invalid Facing";
    public static final String INVALID_X = "Invalid X Point";
    public static final String INVALID_Y = "Invalid Y Point";

    public RobotSimulatorException(String message) {
        super(message);
    }

    public RobotSimulatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public static RobotSimulatorException invalidPlaceCommand() {
        return new RobotSimulatorException(INVALID_PLACE_COMMAND);
    }

    public static RobotSimulatorException invalidFacing() {
        return new RobotSimulatorException(INVALID_FACING);
    }

    public static RobotSimulatorException invalidX() {
        return new RobotSimulatorException(INVALID_X);
    }

    public static RobotSimulatorException invalidY() {
        return new RobotSimulatorException(INVALID_Y);
    }

    public static RobotSimulatorException noInput() {
        return new RobotSimulatorException(NO_FILE_PROVIDED);
    }


}
